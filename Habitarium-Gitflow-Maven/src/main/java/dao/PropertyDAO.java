package main.java.dao;

import main.java.connection.ConnectionFactory;
import main.java.entity.Property;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PropertyDAO implements DAO<Property> {

    private EntityManager entityManager = new ConnectionFactory().getConnection();

    @Override
    public void save(Property property) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(property);
            this.entityManager.getTransaction().commit();
        } catch (Exception error) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public List getList() {
        Query query = this.entityManager.createQuery("SELECT p FROM Property as p");
        return query.getResultList();
    }

    @Override
    public Property update(Property property) {
        Property propertyUp = null;
        try {
            this.entityManager.getTransaction().begin();
            if (property.getId() == null) {
                this.entityManager.persist(property);
            } else {
                propertyUp = this.entityManager.merge(property);
            }
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return propertyUp;
    }

    @Override
    public void delete(Property property) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(property);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }
}

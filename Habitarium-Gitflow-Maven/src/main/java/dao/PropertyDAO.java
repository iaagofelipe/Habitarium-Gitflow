package main.java.dao;

import main.java.connection.ConnectionFactory;
import main.java.entity.Property;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PropertyDAO implements DAO<Property> {

    private EntityManager entityManager = new ConnectionFactory().getConnection();

    @Override
    public void save(Property object) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(object);
            this.entityManager.getTransaction().commit();
        } catch (Exception error) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }

    @Override
    public List get() {
        Query query = this.entityManager.createQuery("SELECT p FROM Property as p");
        return query.getResultList();
    }

    @Override
    public Property update(Property object) {
        Property property = null;
        try {
            this.entityManager.getTransaction().begin();
            property = this.entityManager.merge(object);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return property;
    }
}

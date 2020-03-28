package main.java.dao;

import main.java.connection.ConnectionFactory;
import main.java.entity.Lessor;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class LessorDAO implements DAO<Lessor> {

    private EntityManager entityManager = new ConnectionFactory().getConnection();


    @Override
    public void save(Lessor object) {
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
    public List<Lessor> get() {
        Query query = this.entityManager.createQuery("SELECT l FROM Lessor as l");
        return query.getResultList();
    }

    @Override
    public Lessor update(Lessor object) {
        Lessor lessor = null;
        try {
            this.entityManager.getTransaction().begin();
            lessor = this.entityManager.merge(object);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return lessor;
    }

    @Override
    public void delete(Lessor object) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.remove(object);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
    }
}

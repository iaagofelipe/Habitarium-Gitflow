package main.java.dao;

import main.java.connection.ConnectionFactory;
import main.java.entity.Rent;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class RentDAO implements DAO<Rent> {

   private EntityManager entityManager = new ConnectionFactory().getConnection();

   @Override
   public void save(Rent object) {
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
      Query query = this.entityManager.createQuery("SELECT r FROM Rent as r");
      return query.getResultList();
   }

   @Override
   public Rent update(Rent object) {
      Rent rent = null;
      try {
         this.entityManager.getTransaction().begin();
         rent = this.entityManager.merge(object);
         this.entityManager.getTransaction().commit();
      } catch (Exception exception) {
         this.entityManager.getTransaction().rollback();
      } finally {
         this.entityManager.close();
      }
      return rent;
   }

   @Override
   public void delete(Rent object) {
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

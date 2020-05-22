package main.java.dao;


import main.java.connection.ConnectionFactory;
import main.java.entity.UserAccount;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserAccountDAO implements DAO<UserAccount> {
    private EntityManager entityManager = new ConnectionFactory().getConnection();

    @Override
    public UserAccount save(UserAccount userAccount) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(userAccount);
            this.entityManager.getTransaction().commit();
        } catch (Exception error) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return userAccount;
    }

    @Override
    public List getList() {
        Query query = this.entityManager.createQuery("SELECT r FROM UserAccount as r");
        return query.getResultList();
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        UserAccount userUp = null;
        try {
            this.entityManager.getTransaction().begin();
            if (userAccount.getId() == null) {
                this.entityManager.persist(userAccount);
            } else {
                userUp = this.entityManager.merge(userAccount);
            }
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return userUp;
    }

    @Override
    public UserAccount delete(Long id) {
        UserAccount userAccount = null;
        try {
            userAccount = entityManager.find(UserAccount.class, id);

            this.entityManager.getTransaction().begin();
            this.entityManager.remove(userAccount);
            this.entityManager.getTransaction().commit();
        } catch (Exception exception) {
            this.entityManager.getTransaction().rollback();
        } finally {
            this.entityManager.close();
        }
        return userAccount;
    }

    @Override
    public UserAccount findById(Long id) {
        UserAccount userAccount = null;
        try {
            userAccount = entityManager.find(UserAccount.class, id);
        } catch (Exception e) {
            // TODO: Throw exception here!!
            System.out.println("erro ao buscar por id\n" + e);
        }
        return userAccount;
    }
}

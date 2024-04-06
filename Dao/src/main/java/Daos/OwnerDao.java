package Daos;

import Models.Owner;
import Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Data access object for Owner class
 */
public class OwnerDao {
    private SessionFactory sessionFactory;
    
    public OwnerDao(SessionFactory _sessionFactory){
        sessionFactory = _sessionFactory;
    }

    public void saveOwner(Owner owner) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(owner);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            throw exception;
        }
    }

    public Owner getOwnerById(Integer ownerId) {
        try {
            Session session = sessionFactory.openSession();
            Owner owner = session.get(Owner.class, ownerId);
            session.close();
            return owner;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public void updateOwner(Owner owner) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(owner);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            throw exception;
        }
    }

    public void deleteOwner(Owner owner) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(owner);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            throw exception;
        }
    }
}

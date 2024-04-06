package Daos;

import Models.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Data access object for Cat class
 */
public class CatDao {
    private SessionFactory sessionFactory;

    public CatDao(SessionFactory _sessionFactory){
        sessionFactory = _sessionFactory;
    }
    public void saveCat(Cat cat) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(cat);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            throw exception;
        }
    }

    public Cat getCatById(Integer catId) {
        try {
            Session session = sessionFactory.openSession();
            Cat cat = session.get(Cat.class, catId);
            session.close();
            return cat;
        } catch (Exception exception) {
            throw exception;
        }
    }

    public void updateCat(Cat cat) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(cat);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            throw exception;
        }
    }

    public void deleteCat(Cat cat) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.delete(cat);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            throw exception;
        }
    }

    public void makeNewFriendship(Integer firstCatId, Integer secondCatId) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Cat firstCat = session.get(Cat.class, firstCatId);
            Cat secondCat = session.get(Cat.class, secondCatId);
            firstCat.getFriends().add(secondCat);
            secondCat.getFriends().add(firstCat);
            session.update(firstCat);
            session.update(secondCat);
            transaction.commit();
            session.close();
        } catch (Exception exception) {
            throw exception;
        }
    }

    public List<Cat> getCatsFriends(Integer catId) {
        try {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Cat cat = session.get(Cat.class, catId);
            List<Cat> friends = cat.getFriends();
            transaction.commit();
            session.close();
            return friends;
        } catch (Exception exception) {
            throw exception;
        }
    }
}

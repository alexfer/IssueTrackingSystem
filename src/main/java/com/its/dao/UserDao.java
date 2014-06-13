package com.its.dao;

import com.its.model.Users;
import com.its.util.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author alexander
 */
public class UserDao {

    private static Session session = null;
    private static Transaction tx = null;

    public static List<Users> list() throws Exception {
        List<Users> list = null;
        try {
            Query query = openSession().createQuery("from Users");
            list = query.list();
        } catch (HibernateException e) {
            throw new Exception(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }

    public static Users delete(Users user) throws Exception {
        try {
            beginTransaction();
            session.delete(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return user;
    }

    public static Users get(int id) {
        return (Users) openSession().get(Users.class, id);
    }

    public static Users save(Users user) throws Exception {
        try {
            beginTransaction();
            session.saveOrUpdate(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new Exception(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return user;
    }

    private static Session openSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        return session;
    }

    private static void beginTransaction() {
        tx = openSession().beginTransaction();
    }
}

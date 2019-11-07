package nx_ssb.dao;

import nx_ssb.model.Subscriber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubscriberDAOImpl implements SubscriberDAO{

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Subscriber> getAllSubscribers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Subscriber").list();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(subscriber);
    }

    @Override
    public void deleteSubscriber(Subscriber subscriber) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(subscriber);
    }

    @Override
    public void updateSubscriber(Subscriber subscriber) {
        Session session = sessionFactory.getCurrentSession();
        session.update(subscriber);
    }

    @Override
    public Subscriber getSubscriberById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Subscriber.class, id);
    }

    @Override
    public void customUpdate(String updateQuery) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(updateQuery);
        query.executeUpdate();
    }


    @Override
    public long count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT COUNT (*) FROM Subscriber");
        long result = (long)query.uniqueResult();
        return result;
    }
}

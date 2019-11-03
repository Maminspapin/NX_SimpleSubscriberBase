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
    public List<Subscriber> allSubscribers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Subscriber").list();
    }

    @Override
    public void add(Subscriber subscriber) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(subscriber);
    }

    @Override
    public void delete(Subscriber subscriber) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(subscriber);
    }

    @Override
    public void edit(Subscriber subscriber) {
        Session session = sessionFactory.getCurrentSession();
        session.update(subscriber);
    }

    @Override
    public Subscriber getSubsById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Subscriber.class, id);
    }

    @Override
    public long count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT COUNT (*) FROM Subscriber");
        long result = (long)query.uniqueResult();
        return result;
    }
}

package nx_alc.dao;

import nx_alc.model.Subscriber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class SubscriberDAOImpl implements SubscriberDAO{

    private static final AtomicInteger AUTO_ID = new AtomicInteger(1);
    private static Map<Integer, Subscriber> subscribers = new HashMap<>();
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Subscriber> allSubscribers() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Subscriber").list();
    }

    @Override
    public void add(Subscriber subscriber) {
        subscriber.setId(AUTO_ID.getAndIncrement());
        subscribers.put(subscriber.getId(), subscriber);
    }

    @Override
    public void delete(Subscriber subscriber) {
        subscribers.remove(subscriber.getId());
    }

    @Override
    public void edit(Subscriber subscriber) {
        subscribers.put(subscriber.getId(), subscriber);
    }

    @Override
    public Subscriber getSubsById(int id) {
        return subscribers.get(id);
    }
}

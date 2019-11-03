package nx_alc.dao;

import nx_alc.model.Subscriber;
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

    static {
        Subscriber subs1 = new Subscriber(AUTO_ID.getAndIncrement(), "name1", "lastName1", "testMSISDN1", 10.00);
        Subscriber subs2 = new Subscriber(AUTO_ID.getAndIncrement(),"name2", "lastName2", "testMSISDN2", -10.00);
        Subscriber subs3 = new Subscriber(AUTO_ID.getAndIncrement(), "name3", "lastName3", "testMSISDN3", -30.00);
        subscribers.put(subs1.getId(), subs1);
        subscribers.put(subs2.getId(), subs2);
        subscribers.put(subs3.getId(), subs3);
    }


    @Override
    public List<Subscriber> allSubscribers() {
        return new ArrayList<>(subscribers.values());
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

package nx_ssb.dao;

import nx_ssb.model.Subscriber;

import java.util.List;

public interface SubscriberDAO {

    List<Subscriber> getAllSubscribers();
    void addSubscriber(Subscriber subscriber);
    void deleteSubscriber(Subscriber subscriber);
    void updateSubscriber(Subscriber subscriber);
    Subscriber getSubscriberById(int id);
    void customUpdate(String Query);
    long count();

}

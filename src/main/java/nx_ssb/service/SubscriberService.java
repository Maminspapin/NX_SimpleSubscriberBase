package nx_ssb.service;

import nx_ssb.model.Subscriber;

import java.util.List;

public interface SubscriberService {

    List<Subscriber> getAllSubscribers();
    void addSubscriber(Subscriber subscriber);
    void deleteSubscriber(Subscriber subscriber);
    void updateSubscriber(Subscriber subscriber);
    Subscriber getSubscriberById(int id);
    void doSms(Subscriber subscriber);
    long count();
}

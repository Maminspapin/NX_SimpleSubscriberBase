package nx_ssb.service;

import nx_ssb.model.Subscriber;

import java.util.List;

public interface SubscriberService {

    List<Subscriber> allSubscribers();
    void add(Subscriber subscriber);
    void delete(Subscriber subscriber);
    void edit(Subscriber subscriber);
    Subscriber getSubsById(int id);
    long count();
}

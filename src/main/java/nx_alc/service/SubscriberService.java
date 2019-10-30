package nx_alc.service;

import nx_alc.model.Subscriber;

import java.util.List;

public interface SubscriberService {

    List<Subscriber> allSubscribers();
    void add(Subscriber subscriber);
    void delete(Subscriber subscriber);
    void edit(Subscriber subscriber);
    Subscriber getSubsById(int id);
}

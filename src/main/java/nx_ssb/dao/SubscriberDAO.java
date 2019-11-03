package nx_ssb.dao;

import nx_ssb.model.Subscriber;

import java.util.List;

public interface SubscriberDAO {

    List<Subscriber> allSubscribers();
    void add(Subscriber subscriber);
    void delete(Subscriber subscriber);
    void edit(Subscriber subscriber);
    Subscriber getSubsById(int id);

}

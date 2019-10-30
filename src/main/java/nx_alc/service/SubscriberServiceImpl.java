package nx_alc.service;

import nx_alc.dao.SubscriberDAO;
import nx_alc.dao.SubscriberDAOImpl;
import nx_alc.model.Subscriber;

import java.util.List;

public class SubscriberServiceImpl implements SubscriberService {

    private SubscriberDAO subscriberDAO = new SubscriberDAOImpl();

    @Override
    public List<Subscriber> allSubscribers() {
        return subscriberDAO.allSubscribers();
    }

    @Override
    public void add(Subscriber subscriber) {
        subscriberDAO.add(subscriber);
    }

    @Override
    public void delete(Subscriber subscriber) {
        subscriberDAO.delete(subscriber);
    }

    @Override
    public void edit(Subscriber subscriber) {
        subscriberDAO.edit(subscriber);
    }

    @Override
    public Subscriber getSubsById(int id) {
        return subscriberDAO.getSubsById(id);
    }
}

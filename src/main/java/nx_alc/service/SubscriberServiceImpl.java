package nx_alc.service;

import nx_alc.dao.SubscriberDAO;
import nx_alc.dao.SubscriberDAOImpl;
import nx_alc.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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

    @Autowired
    public void setSubscriberDAO(SubscriberDAO subscriberDAO) {
        this.subscriberDAO = subscriberDAO;
    }
}

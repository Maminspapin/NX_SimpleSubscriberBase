package nx_alc.service;

import nx_alc.dao.SubscriberDAO;
import nx_alc.dao.SubscriberDAOImpl;
import nx_alc.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    private SubscriberDAO subscriberDAO = new SubscriberDAOImpl();

    @Autowired
    public void setSubscriberDAO(SubscriberDAO subscriberDAO) {
        this.subscriberDAO = subscriberDAO;
    }

    @Override
    @Transactional
    public List<Subscriber> allSubscribers() {
        return subscriberDAO.allSubscribers();
    }

    @Override
    @Transactional
    public void add(Subscriber subscriber) {
        subscriberDAO.add(subscriber);
    }

    @Override
    @Transactional
    public void delete(Subscriber subscriber) {
        subscriberDAO.delete(subscriber);
    }

    @Override
    @Transactional
    public void edit(Subscriber subscriber) {
        subscriberDAO.edit(subscriber);
    }

    @Override
    @Transactional
    public Subscriber getSubsById(int id) {
        return subscriberDAO.getSubsById(id);
    }

}

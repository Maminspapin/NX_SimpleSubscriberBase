package nx_ssb.service;

import nx_ssb.dao.SubscriberDAO;
import nx_ssb.dao.SubscriberDAOImpl;
import nx_ssb.model.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
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
    public List<Subscriber> getAllSubscribers() {
        return subscriberDAO.getAllSubscribers();
    }

    @Override
    @Transactional
    public void addSubscriber(Subscriber subscriber) {
        subscriberDAO.addSubscriber(subscriber);
    }

    @Override
    @Transactional
    public void deleteSubscriber(Subscriber subscriber) {
        subscriberDAO.deleteSubscriber(subscriber);
    }

    @Override
    @Transactional
    public void updateSubscriber(Subscriber subscriber) {
        subscriberDAO.updateSubscriber(subscriber);
    }

    @Override
    @Transactional
    public Subscriber getSubscriberById(int id) {
        return subscriberDAO.getSubscriberById(id);
    }

    @Override
    @Transactional
    public void doSms(Subscriber subscriber) {
        String updateQuery = "UPDATE Subscriber SET name = \'sms\' WHERE id = " + subscriber.getId();
        subscriberDAO.customUpdate(updateQuery);
    }

    @Override
    @Transactional
    public long count() {
        return subscriberDAO.count();
    }


}

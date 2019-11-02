package nx_alc.controller;

import nx_alc.model.Subscriber;
import nx_alc.service.SubscriberService;
import nx_alc.service.SubscriberServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SubscriberController {

    private Subscriber subscriber = new Subscriber(0, "Ivan", "Egorov", "8913913913", 120.00);
    private SubscriberService subscriberService = new SubscriberServiceImpl();

    @GetMapping(value = "/info")
    public ModelAndView getSubscriberInfo() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("info");
        return modelAndView;
    }

    @GetMapping(value = "/count")
    public ModelAndView getSubscribersQuantity() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("count");
        return modelAndView;
    }

    //TODO: Need to add other rests

    @GetMapping(value = "/") // only for test, to delete
    public ModelAndView getTestPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test_page");
        return modelAndView;
    }

    @GetMapping(value = "/me") // only for test, to delete
    public ModelAndView getTestMe() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test_hello_me");
        return modelAndView;
    }

    @GetMapping(value = "/subs") // only for test, to delete
    public ModelAndView getTestSubscriber() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test_subs");
        modelAndView.addObject("subscriber", subscriber);
        return modelAndView;
    }

    @GetMapping(value = "/all") // only for test, to delete
    public ModelAndView getTestAllSubscribers() {

        List<Subscriber> subscribers = subscriberService.allSubscribers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test_subscribers");
        modelAndView.addObject("subscribersList", subscribers);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}") // only for test, to delete
    public ModelAndView editPage(@PathVariable("id") int id) {
        Subscriber subscriber = subscriberService.getSubsById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test_edit");
        modelAndView.addObject("subscriber", subscriber);
        return modelAndView;
    }

    @PostMapping(value = "/edit") // only for test, to delete
    public ModelAndView editSubs(@ModelAttribute("subscriber") Subscriber subscriber) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/all");
        subscriberService.edit(subscriber);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("test_edit");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addSubs(@ModelAttribute("subscriber") Subscriber subscriber) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/all");
        subscriberService.add(subscriber);
        return modelAndView;
    }


}

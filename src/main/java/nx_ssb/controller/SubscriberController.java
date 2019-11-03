package nx_ssb.controller;

import nx_ssb.model.Subscriber;
import nx_ssb.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SubscriberController {

    private SubscriberService subscriberService;

    @Autowired
    public void setSubscriberService(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping(value = "/")
    public ModelAndView toMainPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/all");
        return modelAndView;
    }

    @GetMapping(value = "/all")
    public ModelAndView getAllSubscribers() {
        List<Subscriber> subscribers = subscriberService.allSubscribers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("subscribers_page");
        modelAndView.addObject("subscribersList", subscribers);
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView toEditPage(@PathVariable("id") int id) {
        Subscriber subscriber = subscriberService.getSubsById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit_page");
        modelAndView.addObject("subscriber", subscriber);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView editSubs(@ModelAttribute("subscriber") Subscriber subscriber) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/all");
        subscriberService.edit(subscriber);
        return modelAndView;
    }

    @GetMapping(value = "/add")
    public ModelAndView toAddPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("edit_page");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public ModelAndView addSubs(@ModelAttribute("subscriber") Subscriber subscriber) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/all");
        subscriberService.add(subscriber);
        return modelAndView;
    }

    @GetMapping(value="/delete/{id}")
    public ModelAndView deleteSubs(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/all");
        Subscriber subscriber = subscriberService.getSubsById(id);
        subscriberService.delete(subscriber);
        return modelAndView;
    }

    @GetMapping(value = "/count")
    public ModelAndView getSubscribersQuantity() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("count_page");
        long result = subscriberService.count();
        modelAndView.addObject("result", result);
        return modelAndView;
    }

}

package nx_alc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SubscriberController {

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


}
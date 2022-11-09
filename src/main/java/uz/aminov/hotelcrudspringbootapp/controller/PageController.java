package uz.aminov.hotelcrudspringbootapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PageController {

    @GetMapping("/")
    public ModelAndView getHotelPage(){
        ModelAndView modelAndView = new ModelAndView("hotel");
        modelAndView.addObject("var2", 23);
        return modelAndView;
    }
}

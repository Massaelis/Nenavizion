package com.nenavizion.controller;

import com.nenavizion.model.Jewelry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GeneralController {

    @GetMapping()
    public ModelAndView index(ModelAndView modelAndView) {
        List<Jewelry> products = new ArrayList<>();
        final Jewelry jewelry1 = new Jewelry();
        jewelry1.setPrice(25);
        jewelry1.setDescription("fdsdafsdf");
        jewelry1.setLink("product?id=" + jewelry1.getId());
        jewelry1.setPhoto("images/1.png");

        final Jewelry jewelry2 = new Jewelry();
        jewelry2.setPrice(15);
        jewelry2.setDescription("xxxxxxxx");
        jewelry2.setLink("product?id=" + jewelry2.getId());
        jewelry2.setPhoto("images/2.png");

        products.add(jewelry1);
        products.add(jewelry2);

        modelAndView.addObject("products", products);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/about")
    public ModelAndView findById(ModelAndView modelAndView) {
        modelAndView.setViewName("about");
        return modelAndView;
    }}

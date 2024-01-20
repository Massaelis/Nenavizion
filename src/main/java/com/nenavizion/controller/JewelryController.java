package com.nenavizion.controller;

import com.nenavizion.model.Jewelry;
import com.nenavizion.service.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/jewelry")
public class JewelryController {
    private final JewelryService service;

    @Autowired
    public JewelryController(final JewelryService service) {
        this.service = service;
    }


    @GetMapping("/id/{id}")
    public ModelAndView findById(final ModelAndView modelAndView, final @PathVariable String id) {
        modelAndView.addObject("product", service.findById(id));
        modelAndView.setViewName("product");
        return modelAndView;
    }


    @GetMapping("/type/{type}")
    public ModelAndView findByType(final ModelAndView modelAndView, final @PathVariable String type) {
        final Iterable<Jewelry> jewelries;
        if ("all".equals(type)) {
            jewelries = service.findAll();
        } else {
            jewelries = service.findByType(type);
        }
        modelAndView.addObject("products", jewelries);
        modelAndView.setViewName("products");
        return modelAndView;
    }
}
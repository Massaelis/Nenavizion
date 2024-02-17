package com.nenavizion.controller;

import com.nenavizion.model.Jewelry;
import com.nenavizion.service.JewelryService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TestController {

    private final JewelryService jewelryService;

    @Autowired
    public TestController(JewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @GetMapping("/search")
    public ModelAndView getForm(final ModelAndView modelAndView) {
        modelAndView.setViewName("search");
        modelAndView.addObject("searchFilters", new SearchFilters());
        return modelAndView;
    }

    @PostMapping("/search")
    public String postForm(final RedirectAttributes modelAndView, final @ModelAttribute SearchFilters searchFilters) {
        System.out.println(searchFilters);
        final Iterable<Jewelry> result = jewelryService.findByNameContainingIgnoreCase(searchFilters.getName());
        modelAndView.addAttribute("products", result);
        return "redirect:/jewelry/type/all";
    }
}

@Getter
@Setter
@ToString
class SearchFilters {
    private String name;
    private String price;
}

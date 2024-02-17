package com.nenavizion.controller;

import com.nenavizion.Pager;
import com.nenavizion.model.Jewelry;
import com.nenavizion.service.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

// ----------------------------------------------------------------

//    @GetMapping("/jewelryPage")
//    public String listJewelry (Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
//        final int currentPage = page.orElse(1);
//        final int pageSize = size.orElse(5);
//
//        Page<Jewelry> jewelryPage = service.findPaginated(PageRequest.of(currentPage - 1, pageSize));
//
//        model.addAttribute("jewelryPage", jewelryPage);
//
//        int totalPages = jewelryPage.getTotalPages();
//        if (totalPages > 0) {
//            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
//                    .boxed()
//                    .collect(Collectors.toList());
//            model.addAttribute("pageNumbers", pageNumbers);
//        }
//
//        return "jewelryPage.html";
//    }

// ----------------------------------------------------------------
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 0;
    private static final int INITIAL_PAGE_SIZE = 3;
    private static final int[] PAGE_SIZES = { 3, 6, 9, 12 };


    @GetMapping("/jewelryPage")
    public ModelAndView showJewelryPage(final ModelAndView modelAndView, @RequestParam("pageSize")
                                        Optional<Integer> pageSize,
                                        @RequestParam("page") Optional<Integer> page) {

        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);

        int evalPage = page.filter(p -> p >= 1).map(p -> p - 1)
                .orElse(INITIAL_PAGE);

        var jewelry = service.findAllPageable
                (PageRequest.of(evalPage, evalPageSize));
        var pager = new Pager(jewelry.getTotalPages(),
                jewelry.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("product", jewelry);
        modelAndView.addObject("selectedPageSize", evalPageSize);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.setViewName("products");
        return modelAndView;
    }

// ----------------------------------------------------------------
}
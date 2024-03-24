package com.nenavizion.controller;

import com.nenavizion.Pager;
import com.nenavizion.model.Jewelry;
import com.nenavizion.service.JewelryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/jewelry")
public class JewelryController {
    private static final int BUTTONS_TO_SHOW = 3;
    private static final int INITIAL_PAGE = 1;

    private static final int INITIAL_PAGE_SIZE = 3;

    private static final int[] PAGE_SIZES = {3, 6, 9, 12};

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
    public ModelAndView findByType(
            final ModelAndView modelAndView,
            final @PathVariable String type,
            final @ModelAttribute("products") ArrayList<Jewelry> products
    ) {
        final Iterable<Jewelry> jewelries;
        if (products.isEmpty()) {
            if ("all".equals(type)) {
                jewelries = service.findAll();
            } else {
                jewelries = service.findByType(type);
            }
        } else {
            jewelries = products;
        }
        modelAndView.addObject("products", jewelries);
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @GetMapping("/jewelryPage")
    public ModelAndView listJewelry(
            ModelAndView modelAndView,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size
    ) {
        final int currentPage = Math.max(page.orElse(INITIAL_PAGE), 1);
        final int pageSize = size.orElse(INITIAL_PAGE_SIZE);

        Page<Jewelry> jewelryPage = service.findPaginated(
                PageRequest.of(
                        currentPage - 1,
                        pageSize,
                        Sort.Direction.DESC,
                        "price"
                )
        );

//        int evalPageSize = size.orElse(INITIAL_PAGE_SIZE);
//
//        int evalPage = page.filter(p -> p >= 1).map(p -> p - 1)
//                .orElse(INITIAL_PAGE);

//        var users = service.findPaginated
//                (PageRequest.of(evalPage, evalPageSize));
        var pager = new Pager(jewelryPage.getTotalPages(),
                jewelryPage.getNumber(), BUTTONS_TO_SHOW);

        modelAndView.addObject("products", jewelryPage);
        modelAndView.addObject("pageSizes", PAGE_SIZES);
        modelAndView.addObject("pager", pager);
        modelAndView.setViewName("products");

       /* int totalPages = jewelryPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .toList();
            model.addObject("pageNumbers", pageNumbers);
        }*/

        return modelAndView;
    }
}
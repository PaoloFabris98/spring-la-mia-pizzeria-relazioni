package com.example.spring_la_mia_pizzeria_relazioni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.spring_la_mia_pizzeria_relazioni.service.PizzaService;
import com.example.spring_la_mia_pizzeria_relazioni.service.SpecialOffersService;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private SpecialOffersService specialOffersService;

    @GetMapping("/")
    public String index(Model model) {
        if (pizzaService.findAll().size() == 0) {
            model.addAttribute("pizzas", pizzaService.findAll());
            model.addAttribute("isValid", "false");
        } else {
            model.addAttribute("pizzas", pizzaService.findAll());
            model.addAttribute("isValid", "true");
        }
        ;
        return "index/index";
    }

    @GetMapping("/contatti")
    public String contatti(Model model) {
        return "contatti/contatti";
    }
}

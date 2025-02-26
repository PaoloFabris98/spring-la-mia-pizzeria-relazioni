package com.example.spring_la_mia_pizzeria_relazioni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import com.example.spring_la_mia_pizzeria_relazioni.model.Pizza;
import com.example.spring_la_mia_pizzeria_relazioni.model.SpecialOffers;
import com.example.spring_la_mia_pizzeria_relazioni.service.PizzaService;
import com.example.spring_la_mia_pizzeria_relazioni.service.SpecialOffersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OffertaController {
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private SpecialOffersService specialOffersService;

    @GetMapping("/{id}/offerta")
    public String offerta(@PathVariable Integer id, Model model) {
        SpecialOffers specialOffers = new SpecialOffers();
        specialOffers.setPizzeFixedDiscount(pizzaService.findById(id));
        model.addAttribute("offerta", new SpecialOffers());
        return new String();
    }

}

package com.example.spring_la_mia_pizzeria_relazioni.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.spring_la_mia_pizzeria_relazioni.model.SpecialOffers;
import com.example.spring_la_mia_pizzeria_relazioni.service.PizzaService;
import com.example.spring_la_mia_pizzeria_relazioni.service.SpecialOffersService;
import org.springframework.web.bind.annotation.GetMapping;

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
        specialOffers.setDiscountStart(LocalDate.now());
        model.addAttribute("offerta", specialOffers);
        return new String();
    }

}

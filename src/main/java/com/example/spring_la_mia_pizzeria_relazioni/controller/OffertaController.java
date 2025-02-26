package com.example.spring_la_mia_pizzeria_relazioni.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.spring_la_mia_pizzeria_relazioni.model.Pizza;
import com.example.spring_la_mia_pizzeria_relazioni.model.SpecialOffers;
import com.example.spring_la_mia_pizzeria_relazioni.service.PizzaService;
import com.example.spring_la_mia_pizzeria_relazioni.service.SpecialOffersService;

import jakarta.validation.Valid;

@Controller
public class OffertaController {
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private SpecialOffersService specialOffersService;

    @GetMapping("/{id}/offerta")
    public String offerta(@PathVariable Integer id, Model model) {
        SpecialOffers specialOffers = new SpecialOffers();
        Pizza pizza = pizzaService.findById(id);
        specialOffers.getPizzeFixedDiscount().add(pizza);
        specialOffers.getPizzePercentageDiscount().add(pizza);
        specialOffers.setDiscountStart(LocalDate.now());
        System.out.println(specialOffers.discountStart);
        model.addAttribute("offerta", specialOffers);
        model.addAttribute("pizza", pizza);
        return "offerta/offerta";
    }

    @PostMapping("/{id}/offerta")
    public String offerta(@Valid @ModelAttribute("offerta") SpecialOffers formOfferta, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "offerta/offerta";
        }

        return "redirect:/";
    }

}

package com.example.spring_la_mia_pizzeria_relazioni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.spring_la_mia_pizzeria_relazioni.model.Allergene;
import com.example.spring_la_mia_pizzeria_relazioni.service.AllergeniService;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AllergeneController {
    @Autowired
    private AllergeniService allergeniService;

    @GetMapping("/creaAllergene")
    public String addAllergene(Model model) {
        Allergene allergene = new Allergene();
        model.addAttribute("allergene", allergene);
        return "allergene/allergene";
    }

}

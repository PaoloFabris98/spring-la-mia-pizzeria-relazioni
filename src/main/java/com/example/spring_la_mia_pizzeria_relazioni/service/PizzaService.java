package com.example.spring_la_mia_pizzeria_relazioni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring_la_mia_pizzeria_relazioni.model.Ingrediente;
import com.example.spring_la_mia_pizzeria_relazioni.model.Pizza;
import com.example.spring_la_mia_pizzeria_relazioni.repository.IngredientiRepository;
import com.example.spring_la_mia_pizzeria_relazioni.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private IngredientiRepository ingredienteRepository;

    public List<Pizza> findAll() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> findById(int Id) {
        return pizzaRepository.findById(Id);
    }

    public List<Pizza> findByNomeContaining(String nome) {
        return pizzaRepository.findByNomeContaining(nome);
    }

    public Pizza save(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public void deleteById(int id) {
        pizzaRepository.deleteById(id);
    }
}

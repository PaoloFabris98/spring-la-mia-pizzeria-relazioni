package com.example.spring_la_mia_pizzeria_relazioni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_la_mia_pizzeria_relazioni.model.SpecialOffers;
import com.example.spring_la_mia_pizzeria_relazioni.repository.SpecialOffersReporitory;

import jakarta.transaction.Transactional;

@Service
public class SpecialOffersService {
    @Autowired
    private SpecialOffersReporitory specialOffersReporitory;

    public SpecialOffers create(SpecialOffers offerta) {
        return specialOffersReporitory.save(offerta);
    }

}

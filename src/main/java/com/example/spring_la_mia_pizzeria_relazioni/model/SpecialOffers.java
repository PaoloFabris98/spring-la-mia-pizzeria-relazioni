package com.example.spring_la_mia_pizzeria_relazioni.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class SpecialOffers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Lob
    @NotBlank(message = "La descrizione non può essere vuota")
    private String descrizione;

    @Min(value = 0, message = "Il prezzo dev'essere superiore a 0")
    private int fixedDiscount;

    @Min(value = 0, message = "Il prezzo dev'essere superiore a 0")
    private int percentageDiscount;

    private LocalDate discountStart;

    private LocalDate discountEnd;

    @OneToMany(mappedBy = "fixedDiscount")
    private List<Pizza> pizzeFixedDiscount = new ArrayList<>();

    @OneToMany(mappedBy = "percentageDiscount")
    private List<Pizza> pizzePercentageDiscount = new ArrayList<>();

    public SpecialOffers() {
    }

    public SpecialOffers(int id, String descrizione, int fixedDiscount, int percentageDiscount, LocalDate discountStart,
            LocalDate discountEnd, List<Pizza> pizzeFixedDiscount, List<Pizza> pizzePercentageDiscount) {
        this.id = id;
        this.descrizione = descrizione;
        this.fixedDiscount = fixedDiscount;
        this.percentageDiscount = percentageDiscount;
        this.discountStart = discountStart;
        this.discountEnd = discountEnd;
        this.pizzeFixedDiscount = pizzeFixedDiscount;
        this.pizzePercentageDiscount = pizzePercentageDiscount;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getFixedDiscount() {
        return this.fixedDiscount;
    }

    public void setFixedDiscount(int fixedDiscount) {
        this.fixedDiscount = fixedDiscount;
    }

    public int getPercentageDiscount() {
        return this.percentageDiscount;
    }

    public void setPercentageDiscount(int percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public LocalDate getDiscountStart() {
        return discountStart;
    }

    public void setDiscountStart(LocalDate discountStart) {
        this.discountStart = discountStart;
    }

    public LocalDate getDiscountEnd() {
        return discountEnd;
    }

    public void setDiscountEnd(LocalDate discountEnd) {
        this.discountEnd = discountEnd;
    }

    public List<Pizza> getPizzeFixedDiscount() {
        return this.pizzeFixedDiscount;
    }

    public void setPizzeFixedDiscount(List<Pizza> pizzeFixedDiscount) {
        this.pizzeFixedDiscount = pizzeFixedDiscount;
    }

    public List<Pizza> getPizzePercentageDiscount() {
        return this.pizzePercentageDiscount;
    }

    public void setPizzePercentageDiscount(List<Pizza> pizzePercentageDiscount) {
        this.pizzePercentageDiscount = pizzePercentageDiscount;
    }

}

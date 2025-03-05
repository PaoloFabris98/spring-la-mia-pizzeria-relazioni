package com.example.spring_la_mia_pizzeria_relazioni.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String nome;

    // @NotEmpty
    // private String tipo;

    @ManyToMany(mappedBy = "ingredienti")
    private List<Pizza> pizze;

    @ManyToMany
    @JoinTable(name = "allergene_ingrediente", joinColumns = @JoinColumn(name = "allergene_id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id"))
    private List<Allergene> allergeni;

    public Ingrediente() {
    }

    public Ingrediente(String nomeIngrediente) {
        this.nome = nomeIngrediente;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /*
     * public List<Pizza> getPizze() {
     * return this.pizze;
     * }
     * 
     * public void setPizze(List<Pizza> pizze) {
     * this.pizze = pizze;
     * }
     */

    @Override
    public String toString() {
        return this.nome;
    }
}

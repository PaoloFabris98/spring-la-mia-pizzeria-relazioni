package com.example.spring_la_mia_pizzeria_relazioni.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_la_mia_pizzeria_relazioni.model.Allergene;

@Repository
public interface AllergeniRepository extends JpaRepository<Allergene, Integer> {

}

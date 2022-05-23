package com.example.PruebaMicrobus.repository;

import com.example.PruebaMicrobus.model.Alcaldia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAlcaldias extends JpaRepository<Alcaldia,Long> {
    Iterable<Alcaldia> findAllByStatus(boolean status);

    Alcaldia findAllByNombre(String nombre);
}

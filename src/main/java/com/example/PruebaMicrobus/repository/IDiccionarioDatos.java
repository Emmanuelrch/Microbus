package com.example.PruebaMicrobus.repository;

import com.example.PruebaMicrobus.model.DiccionarioDatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiccionarioDatos extends JpaRepository<DiccionarioDatos, Long> {
  DiccionarioDatos findAllById(int id);
  Iterable<DiccionarioDatos> findAllByAlcaldiaId(int id);

  Iterable<DiccionarioDatos> findAllByVehicleCurrentStatus(Double status);
}

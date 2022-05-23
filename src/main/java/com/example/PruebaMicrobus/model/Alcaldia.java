package com.example.PruebaMicrobus.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "alcaldia")
public class Alcaldia {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "status")
    private Boolean status;



}

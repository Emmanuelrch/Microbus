package com.example.PruebaMicrobus.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
public class AlcaldiaDisponibleResponse {
    private String nombre;
    private Boolean status;

}

package com.example.PruebaMicrobus.controller;

import com.example.PruebaMicrobus.model.request.ConsultaAlcaldiasDisponibles;
import com.example.PruebaMicrobus.model.request.UnidadAlcaldia;
import com.example.PruebaMicrobus.model.response.AlcaldiaDisponibleResponse;
import com.example.PruebaMicrobus.model.response.UnidadDisponibleResponse;
import com.example.PruebaMicrobus.repository.IAlcaldias;
import com.example.PruebaMicrobus.service.AlcaldiaSevice;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Emmanuel
 * Esta clase se encarga de traer la informacion de las unidades que se encuentran disponibles dependiendo
 * dentro de la alcaldia asi como el estatus en el que se encuentran las unidades.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadPorAlcaldiaController {
    final IAlcaldias alcaldia;
    final AlcaldiaSevice alcaldiaSevice;

    public UnidadPorAlcaldiaController(IAlcaldias alcaldia, AlcaldiaSevice alcaldiaSevice) {
        this.alcaldia = alcaldia;
        this.alcaldiaSevice = alcaldiaSevice;
    }

    @RequestMapping(path = "/unidadDisponibleAlcaldia", method = RequestMethod.POST)
    public ArrayList<UnidadDisponibleResponse>  consultaAlcaldias(@RequestBody UnidadAlcaldia body) {

        return alcaldiaSevice.unidadDisponible(body.getAlcaldia());
    }
}

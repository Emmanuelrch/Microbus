package com.example.PruebaMicrobus.controller;

import com.example.PruebaMicrobus.model.Alcaldia;
import com.example.PruebaMicrobus.model.DiccionarioDatos;
import com.example.PruebaMicrobus.model.request.ConsultaAlcaldiasDisponibles;
import com.example.PruebaMicrobus.model.request.ConsultaUbicacionMicrobus;
import com.example.PruebaMicrobus.model.request.ConsultaUnidadDisponible;
import com.example.PruebaMicrobus.model.response.AlcaldiaDisponibleResponse;
import com.example.PruebaMicrobus.model.response.UbicacionResponse;
import com.example.PruebaMicrobus.repository.IAlcaldias;
import com.example.PruebaMicrobus.repository.IDiccionarioDatos;
import com.example.PruebaMicrobus.service.AlcaldiaSevice;
import com.example.PruebaMicrobus.service.DiccionarioDatosService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Emmanuel
 * Esta clase se encarga de traer aquellas alcaldias que se encuentran disponibles.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
public class ObtenerAlcaldiasController {
    final IAlcaldias alcaldia;
    final AlcaldiaSevice alcaldiaSevice;

    public ObtenerAlcaldiasController(IAlcaldias alcaldia, AlcaldiaSevice alcaldiaSevice) {
        this.alcaldia = alcaldia;
        this.alcaldiaSevice = alcaldiaSevice;
    }

    @RequestMapping(path = "/consultaAlcaldias", method = RequestMethod.POST)
    public ArrayList<AlcaldiaDisponibleResponse> consultaAlcaldias(@RequestBody ConsultaAlcaldiasDisponibles body) {

        return alcaldiaSevice.alcaldiaDisponible(body.isStatus());
    }
}

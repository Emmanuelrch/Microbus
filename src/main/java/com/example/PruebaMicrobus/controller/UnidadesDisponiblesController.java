package com.example.PruebaMicrobus.controller;

import com.example.PruebaMicrobus.model.DiccionarioDatos;
import com.example.PruebaMicrobus.model.request.ConsultaUnidadDisponible;
import com.example.PruebaMicrobus.repository.IDiccionarioDatos;
import com.example.PruebaMicrobus.service.DiccionarioDatosService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Emmanuel
 * Esta clase se encarga de regresar la informacion toda la informacion dispinible
 * dependiendo de estatus en el que se encuentre la unidad
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
public class UnidadesDisponiblesController {
  final IDiccionarioDatos diccionarioDatos;
  final DiccionarioDatosService diccionarioDatosService;

  public UnidadesDisponiblesController(
      DiccionarioDatosService diccionarioDatosService, IDiccionarioDatos diccionarioDatos) {
    this.diccionarioDatosService = diccionarioDatosService;
    this.diccionarioDatos = diccionarioDatos;
  }

  @RequestMapping(path = "/unidadesDisponibles", method = RequestMethod.POST)
  public Iterable<DiccionarioDatos> unidadesDisponibles(
      @RequestBody ConsultaUnidadDisponible body) {

    return diccionarioDatosService.datosDisponibles(body.getStatus());
  }
}

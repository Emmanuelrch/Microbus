package com.example.PruebaMicrobus.controller;

import com.example.PruebaMicrobus.model.request.ConsultaUbicacionMicrobus;
import com.example.PruebaMicrobus.model.response.UbicacionResponse;
import com.example.PruebaMicrobus.repository.IDiccionarioDatos;
import com.example.PruebaMicrobus.service.DiccionarioDatosService;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Emmanuel
 * Esta case se encarga de revisar las unidades que estan en la alcaldia
 * correspondiente y te indica si esta en disponibilidad o no
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Validated
@RequestMapping(path = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
public class ConsutlaUbicacionController {
  final IDiccionarioDatos diccionarioDatos;
  final DiccionarioDatosService diccionarioDatosService;

  public ConsutlaUbicacionController(
      DiccionarioDatosService diccionarioDatosService, IDiccionarioDatos diccionarioDatos) {
    this.diccionarioDatosService = diccionarioDatosService;
    this.diccionarioDatos = diccionarioDatos;
  }

  @RequestMapping(path = "/consultaUbicacion", method = RequestMethod.POST)
  public UbicacionResponse cosultarUbicacion(@RequestBody ConsultaUbicacionMicrobus body) {

    return diccionarioDatosService.recoleccionDatos(body.getId());
  }
}

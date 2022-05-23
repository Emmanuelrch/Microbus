package com.example.PruebaMicrobus.service;

import com.example.PruebaMicrobus.model.DiccionarioDatos;
import com.example.PruebaMicrobus.model.response.UbicacionResponse;
import com.example.PruebaMicrobus.repository.IDiccionarioDatos;
import org.springframework.stereotype.Service;

/**
 * @author Emmanuel
 * Esta clse se encarga de realizar el funcionamiento para las clases que la soliciten.
 */
@Service
public class DiccionarioDatosService {
  private IDiccionarioDatos diccionarioDatos;

  public DiccionarioDatosService(IDiccionarioDatos diccionarioDatos) {
    this.diccionarioDatos = diccionarioDatos;
  }

  /**
   * Se encarga de regresar la ubicacion de la unidad corresponiente al id
   * @param id valor que tiene la unidad
   * @return informacion de localizacion de la unidad.
   */
  public UbicacionResponse recoleccionDatos(int id) {

    DiccionarioDatos info = diccionarioDatos.findAllById(id);
    UbicacionResponse response = new UbicacionResponse();
    response.setPositionLatitude(info.getPositionLatitude());
    response.setPositionLongitude(info.getPositionLongitude());
    response.setGeographicPoint(info.getGeographicPoint());

    return response;
  }

  /**
   * Obtiene la informacion de las unidades que se encuentran disponibles segun sea su estatus.
   * @param status valor entero que indicara que registros trae.
   * @return lista con todas las unidades correspondientes.
   */
  public Iterable<DiccionarioDatos> datosDisponibles(int status) {
    return diccionarioDatos.findAllByVehicleCurrentStatus(
        Double.parseDouble(String.valueOf(status)));
  }
}

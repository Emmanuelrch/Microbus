package com.example.PruebaMicrobus.service;


import com.example.PruebaMicrobus.model.Alcaldia;
import com.example.PruebaMicrobus.model.DiccionarioDatos;
import com.example.PruebaMicrobus.model.response.AlcaldiaDisponibleResponse;
import com.example.PruebaMicrobus.model.response.UnidadDisponibleResponse;
import com.example.PruebaMicrobus.repository.IAlcaldias;
import com.example.PruebaMicrobus.repository.IDiccionarioDatos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
/**
 * @author Emmanuel
 * Esta clse se encarga de realizar el funcionamiento para las clases que la soliciten.
 */
@Service
public class AlcaldiaSevice {

  final IAlcaldias alcaldias;
  final IDiccionarioDatos diccionarioDatos;

    public AlcaldiaSevice(IAlcaldias alcaldias, IDiccionarioDatos diccionarioDatos) {
        this.alcaldias = alcaldias;
      this.diccionarioDatos = diccionarioDatos;
    }

    public ArrayList<AlcaldiaDisponibleResponse> alcaldiaDisponible(boolean status) {

      Iterable<Alcaldia> datos=alcaldias.findAllByStatus(status);
      ArrayList<AlcaldiaDisponibleResponse> alcaldiainfo=new ArrayList<>();
      datos.forEach(a->{
      AlcaldiaDisponibleResponse aux=new AlcaldiaDisponibleResponse();
      aux.setNombre(a.getNombre());
      aux.setStatus(a.getStatus());
      alcaldiainfo.add(aux);

      } );

      return alcaldiainfo;
  }

  /**
   * Este metodo se encarga de estraer la informacionde las unidadedes que estan disponibles.
   * @param alcaldia cadena con el nombre de la alcaldia.
   * @return arreglo con las unidades disponibles.
   */
  public ArrayList<UnidadDisponibleResponse> unidadDisponible(String alcaldia) {
      Alcaldia alcaldiarequerida=alcaldias.findAllByNombre(alcaldia);
      Long idAlcaldia=alcaldiarequerida.getId();
      Iterable<DiccionarioDatos> unidades=diccionarioDatos.findAllByAlcaldiaId(idAlcaldia.intValue());
      ArrayList<UnidadDisponibleResponse> unidadesDisponible=new ArrayList<>();
      unidades.forEach(
        unidad -> {
          UnidadDisponibleResponse aux = new UnidadDisponibleResponse();
          aux.setVehicleLabel(unidad.getVehicleLabel());
          aux.setVehicleCurrentStatus(obtenerStatus(unidad.getVehicleCurrentStatus().intValue()));
          unidadesDisponible.add(aux);
        });
      return unidadesDisponible;
  }

  /**
   * Se encarga de generar un mapeo para el tipo de valor requerido
   * @param valor valor entero
   * @return mensaje.
   */
  private String obtenerStatus(int valor){
      String mensaje="";
      switch (valor){
        case 1:
          mensaje="Disponible";
          break;

        case 2:
          mensaje="No Disponible";
            break;
        default:
          mensaje="Informacion no disponible";
          break;

      }
      return mensaje;
  }
}
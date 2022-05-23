package com.example.PruebaMicrobus.model.response;

import lombok.Data;

@Data
public class UbicacionResponse {
  private Double positionLatitude;
  private Double positionLongitude;
  private String geographicPoint;
}

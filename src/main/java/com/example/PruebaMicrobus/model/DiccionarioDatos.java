package com.example.PruebaMicrobus.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "diccionario_datos")
public class DiccionarioDatos {
  @Id
  @Column(name = "id_tabla", nullable = false)
  private long idTabla;

  @Basic
  @Column(name = "date_updated", nullable = true)
  private String dateUpdated;

  @Basic
  @Column(name = "vehicle_id", nullable = true)
  private Integer vehicleId;

  @Basic
  @Column(name = "vehicle_label", nullable = true)
  private Double vehicleLabel;

  @Basic
  @Column(name = "vehicle_current_status", nullable = true)
  private Double vehicleCurrentStatus;

  @Basic
  @Column(name = "position_latitude", nullable = true)
  private Double positionLatitude;

  @Basic
  @Column(name = "position_longitude", nullable = true)
  private Double positionLongitude;

  @Basic
  @Column(name = "geographic_point", nullable = true)
  private String geographicPoint;

  @Basic
  @Column(name = "position_speed", nullable = true)
  private Double positionSpeed;

  @Basic
  @Column(name = "position_odometer", nullable = true)
  private Double positionOdometer;

  @Basic
  @Column(name = "trip_schedule_relationship", nullable = true)
  private Double tripScheduleRelationship;

  @Basic
  @Column(name = "trip_id", nullable = true)
  private Double tripId;

  @Basic
  @Column(name = "trip_start_date", nullable = true)
  private BigInteger tripStartDate;

  @Basic
  @Column(name = "trip_route_id", nullable = true)
  private Integer tripRouteId;

  @Basic
  @Column(name = "id")
  private int id;
  @Column(name = "alcaldiaid")
  private int alcaldiaId;
}

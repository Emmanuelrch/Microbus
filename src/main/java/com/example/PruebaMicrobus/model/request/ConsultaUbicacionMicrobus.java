package com.example.PruebaMicrobus.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

import static com.example.PruebaMicrobus.util.Constantes.PARAMETRO_INVALIDO_SOLO_NUMEROS;
import static com.example.PruebaMicrobus.util.Constantes.SOLO_NUMEROS_REGEX;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaUbicacionMicrobus {
  @Pattern(regexp = SOLO_NUMEROS_REGEX, message = PARAMETRO_INVALIDO_SOLO_NUMEROS)
  private Integer id;
}

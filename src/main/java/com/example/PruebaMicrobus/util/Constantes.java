package com.example.PruebaMicrobus.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constantes {
  public static final String SOLO_NUMEROS_REGEX = "|^(\\S*|[0-9]+)$";
  public static final String PARAMETRO_INVALIDO_SOLO_NUMEROS =
      "El parametro no es permitido ya que no es un numero";
  public static final String PARAMETRO_REQUERIDO =
      "El parametro es necesario para su ejecucion";
}

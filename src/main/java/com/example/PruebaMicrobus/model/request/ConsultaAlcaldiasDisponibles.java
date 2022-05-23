package com.example.PruebaMicrobus.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

import static com.example.PruebaMicrobus.util.Constantes.PARAMETRO_REQUERIDO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaAlcaldiasDisponibles {
    @NotBlank(message = PARAMETRO_REQUERIDO)
    boolean status;
}

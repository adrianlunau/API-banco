package com.apiBancoSP.bancosp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Data
public class TransaccionDTO {

    private Long idTransaccion;
    private String tarjetaOrigen;
    private Double monto;
    private LocalDate fecha;
    private String tarjetaDestino;
}

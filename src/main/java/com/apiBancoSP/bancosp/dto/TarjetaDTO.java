package com.apiBancoSP.bancosp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class TarjetaDTO {

    private String nroDeCuenta;
    private Long cliente;
    private Integer pin;
    private Double saldo;
    private List<TransaccionDTO> transacciones = new ArrayList<>();


}


package com.apiBancoSP.bancosp.service;

import com.apiBancoSP.bancosp.dto.TarjetaDTO;
import com.apiBancoSP.bancosp.dto.TransaccionDTO;

import java.util.List;

public interface TarjetaService {

    TarjetaDTO getDetails(String nroTarjeta);

    Double getSaldo(String nroTarjeta);

    List<TransaccionDTO> getTransacciones();
}

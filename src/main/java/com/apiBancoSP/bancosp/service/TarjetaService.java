package com.apiBancoSP.bancosp.service;

import com.apiBancoSP.bancosp.dto.TarjetaDTO;
import com.apiBancoSP.bancosp.dto.TransaccionDTO;

import java.util.List;

public interface TarjetaService {

    TarjetaDTO getDetails();

    Double getSaldo();

    List<TransaccionDTO> getTransacciones();
}

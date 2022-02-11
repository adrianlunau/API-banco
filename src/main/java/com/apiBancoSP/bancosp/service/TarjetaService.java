package com.apiBancoSP.bancosp.service;

import com.apiBancoSP.bancosp.dto.TarjetaDTO;

public interface TarjetaService {

    TarjetaDTO getDetails(String jwt);
}

package com.apiBancoSP.bancosp.service;

import com.apiBancoSP.bancosp.dto.TransaccionDTO;

public interface TransaccionService {

    TransaccionDTO transferir (TransaccionDTO dto);
}

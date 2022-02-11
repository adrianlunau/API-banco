package com.apiBancoSP.bancosp.mapper;

import com.apiBancoSP.bancosp.dto.TarjetaDTO;
import com.apiBancoSP.bancosp.entity.TarjetaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TarjetaMapper {

    @Autowired
    private TransaccionMapper transaccionMapper;

    public TarjetaDTO tarjetaEntity2DTO(TarjetaEntity entity){
        TarjetaDTO dto = new TarjetaDTO();
        dto.setCliente(entity.getClienteId());
        dto.setNroDeCuenta(entity.getNroDeCuenta());
        dto.setPin(entity.getPin());
        dto.setSaldo(entity.getSaldo());
        dto.setTransacciones(transaccionMapper.transaccionEntityList2DTO(entity.getTransacciones()));

        return dto;
    }


}

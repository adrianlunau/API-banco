package com.apiBancoSP.bancosp.mapper;

import com.apiBancoSP.bancosp.dto.TransaccionDTO;
import com.apiBancoSP.bancosp.entity.TransaccionEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransaccionMapper {

    public TransaccionDTO transaccionEntity2DTO (TransaccionEntity entity){
        TransaccionDTO dto = new TransaccionDTO();
        dto.setIdTransaccion(entity.getIdTransaccion());
        dto.setFecha(entity.getFecha());
        dto.setMonto(entity.getMonto());
        dto.setTarjetaDestino(entity.getTarjetaDestino());
        dto.setTarjetaOrigen(entity.getNroTarjetaOrigen());
        return dto;
    }

    public List<TransaccionDTO> transaccionEntityList2DTO (List<TransaccionEntity> entities){
        List<TransaccionDTO> dtos = new ArrayList<>();
        for (TransaccionEntity entity : entities) {
            dtos.add(this.transaccionEntity2DTO(entity));
        }
        return dtos;
    }
}

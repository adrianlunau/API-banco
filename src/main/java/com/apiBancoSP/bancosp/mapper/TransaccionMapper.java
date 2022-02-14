package com.apiBancoSP.bancosp.mapper;

import com.apiBancoSP.bancosp.auth.service.JWTUtils;
import com.apiBancoSP.bancosp.auth.service.SessionManager;
import com.apiBancoSP.bancosp.dto.TransaccionDTO;
import com.apiBancoSP.bancosp.entity.TarjetaEntity;
import com.apiBancoSP.bancosp.entity.TransaccionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransaccionMapper {

    @Autowired
    private SessionManager sessionManager;
    @Autowired
    @Lazy
    private TarjetaMapper tarjetaMapper;

    public TransaccionDTO transaccionEntity2DTO(TransaccionEntity entity) {
        TransaccionDTO dto = new TransaccionDTO();
        dto.setIdTransaccion(entity.getIdTransaccion());
        dto.setFecha(entity.getFecha());
        dto.setMonto(entity.getMonto());
        dto.setTarjetaDestino(entity.getNroTarjetaDestino());
        dto.setTarjetaOrigen(entity.getNroTarjetaOrigen());
        return dto;
    }

    public List<TransaccionDTO> transaccionEntityList2DTO(List<TransaccionEntity> entities) {
        List<TransaccionDTO> dtos = new ArrayList<>();
        for (TransaccionEntity entity : entities) {
            dtos.add(this.transaccionEntity2DTO(entity));
        }
        return dtos;
    }

    public TransaccionEntity transaccionDTO2Entity(TransaccionDTO dto) {
        TransaccionEntity entity = new TransaccionEntity();
        entity.setNroTarjetaDestino(dto.getTarjetaDestino());
        entity.setMonto(dto.getMonto());
        entity.setFecha(LocalDate.now());
        entity.setNroTarjetaOrigen(sessionManager.getUsernameFromSecurityContext());

        return entity;
    }
}



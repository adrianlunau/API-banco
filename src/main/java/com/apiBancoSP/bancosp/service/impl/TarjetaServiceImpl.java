package com.apiBancoSP.bancosp.service.impl;

import com.apiBancoSP.bancosp.auth.service.JWTUtils;
import com.apiBancoSP.bancosp.auth.service.SessionManager;
import com.apiBancoSP.bancosp.dto.TarjetaDTO;
import com.apiBancoSP.bancosp.dto.TransaccionDTO;
import com.apiBancoSP.bancosp.entity.TarjetaEntity;
import com.apiBancoSP.bancosp.entity.TransaccionEntity;
import com.apiBancoSP.bancosp.mapper.TarjetaMapper;
import com.apiBancoSP.bancosp.mapper.TransaccionMapper;
import com.apiBancoSP.bancosp.repository.TarjetaRepository;
import com.apiBancoSP.bancosp.repository.TransaccionRepository;
import com.apiBancoSP.bancosp.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarjetaServiceImpl implements TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;
    @Autowired
    private TarjetaMapper tarjetaMapper;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private SessionManager sessionManager;
    @Autowired
    private TransaccionMapper transaccionMapper;
    @Autowired
    private TransaccionRepository transaccionRepository;

    @Override
    public TarjetaDTO getDetails(String nroTarjeta) {
        Optional<TarjetaEntity> entity = tarjetaRepository.findById(nroTarjeta);
        TarjetaDTO result = tarjetaMapper.tarjetaEntity2DTO(entity.get());
        return result;
    }

    @Override
    public Double getSaldo(String nroTarjeta) {
        Optional<TarjetaEntity> entity = tarjetaRepository.findById(nroTarjeta);
        Double saldo = entity.get().getSaldo();
        return saldo;
    }

    @Override
    public List<TransaccionDTO> getTransacciones() {
        String username = sessionManager.getUsernameFromSecurityContext();
        Pageable pageable = PageRequest.of(0,10);
        List<TransaccionEntity> entities = tarjetaRepository.findLastTenTransaction(username, pageable);
        List<TransaccionDTO> dtos = transaccionMapper.transaccionEntityList2DTO(entities);
        return dtos;
    }
}

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

import java.util.*;

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
    public TarjetaDTO getDetails() {
        String username = sessionManager.getUsernameFromSecurityContext();
        Optional<TarjetaEntity> entity = tarjetaRepository.findById(username);
        TarjetaDTO result = tarjetaMapper.tarjetaEntity2DTO(entity.get());
        return result;
    }

    @Override
    public Double getSaldo() {
        String username = sessionManager.getUsernameFromSecurityContext();
        Optional<TarjetaEntity> entity = tarjetaRepository.findById(username);
        Double saldo = entity.get().getSaldo();
        return saldo;
    }

    @Override
    public List<TransaccionDTO> getTransacciones() {
        String username = sessionManager.getUsernameFromSecurityContext();
        Pageable pageable = PageRequest.of(0,10);
        List<TransaccionEntity> salientes = tarjetaRepository.findLastTenTransaccionesSalientes(username, pageable);
        List<TransaccionEntity> entrantes = tarjetaRepository.findLastTenTransaccionesEntrantes(username, pageable);
        List<TransaccionEntity> sumArrays = new ArrayList<>();
        sumArrays.addAll(entrantes);
        sumArrays.addAll(salientes);
        Collections.sort(sumArrays);
        List<TransaccionDTO> dtos = transaccionMapper.transaccionEntityList2DTO(sumArrays.subList(0,10));

        return dtos;
    }
}

package com.apiBancoSP.bancosp.service.impl;

import com.apiBancoSP.bancosp.auth.service.JWTUtils;
import com.apiBancoSP.bancosp.dto.TarjetaDTO;
import com.apiBancoSP.bancosp.entity.TarjetaEntity;
import com.apiBancoSP.bancosp.mapper.TarjetaMapper;
import com.apiBancoSP.bancosp.repository.TarjetaRepository;
import com.apiBancoSP.bancosp.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TarjetaServiceImpl implements TarjetaService {

    @Autowired
    private TarjetaRepository tarjetaRepository;
    @Autowired
    private TarjetaMapper tarjetaMapper;
    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public TarjetaDTO getDetails(String jwt) {
        String nroTarjeta = jwtUtils.extractUsername(jwt.substring(7));
        Optional<TarjetaEntity> entity = tarjetaRepository.findById(nroTarjeta);
        TarjetaDTO result = tarjetaMapper.tarjetaEntity2DTO(entity.get());
        return result;
    }
}

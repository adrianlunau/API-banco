package com.apiBancoSP.bancosp.service.impl;

import com.apiBancoSP.bancosp.dto.TransaccionDTO;
import com.apiBancoSP.bancosp.entity.TarjetaEntity;
import com.apiBancoSP.bancosp.entity.TransaccionEntity;
import com.apiBancoSP.bancosp.exception.ParamNotFound;
import com.apiBancoSP.bancosp.mapper.TransaccionMapper;
import com.apiBancoSP.bancosp.repository.TarjetaRepository;
import com.apiBancoSP.bancosp.repository.TransaccionRepository;
import com.apiBancoSP.bancosp.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransaccionServiceImpl implements TransaccionService {

    @Autowired
    private TransaccionRepository transaccionRepository;
    @Autowired
    private TarjetaRepository tarjetaRepository;
    @Autowired
    private TransaccionMapper transaccionMapper;

    @Override
    public TransaccionDTO transferir(TransaccionDTO dto) {

        TransaccionEntity entity = transaccionMapper.transaccionDTO2Entity(dto);

        Optional<TarjetaEntity> origen = tarjetaRepository.findById(entity.getNroTarjetaOrigen());
        Optional<TarjetaEntity> destino = tarjetaRepository.findById(dto.getTarjetaDestino());
        if (!destino.isPresent()){
            throw new ParamNotFound("Cuenta destino invalida");
        }

        if (!origen.get().puedeTransferir(dto.getMonto())){
            throw new ParamNotFound("Dinero insuficiente");
        }
        origen.get().descontarSaldo(dto.getMonto());
        destino.get().agregarSaldo(dto.getMonto());

        TransaccionEntity transaccionGuardada = transaccionRepository.save(entity);

        origen.get().agregarTransaccion(transaccionGuardada);
        destino.get().agregarTransaccion(transaccionGuardada);

        TarjetaEntity origenSaved = tarjetaRepository.save(origen.get());
        TarjetaEntity destinoSaved = tarjetaRepository.save(destino.get());

        TransaccionDTO result = transaccionMapper.transaccionEntity2DTO(transaccionGuardada);
        return result;
    }
}

package com.apiBancoSP.bancosp.auth.service;

import com.apiBancoSP.bancosp.entity.TarjetaEntity;
import com.apiBancoSP.bancosp.repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private TarjetaRepository tarjetaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<TarjetaEntity> tarjetaEntity = tarjetaRepository.findById(username);
        if (!tarjetaEntity.isPresent()){
            throw new UsernameNotFoundException("Username or password not found");
        }
        TarjetaEntity tarjeta = tarjetaEntity.get();
        return new User(tarjeta.getNroDeCuenta(), String.valueOf(tarjeta.getPin()), Collections.emptyList()
        );
    }
}

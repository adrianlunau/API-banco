package com.apiBancoSP.bancosp.controller;

import com.apiBancoSP.bancosp.auth.service.JWTUtils;
import com.apiBancoSP.bancosp.dto.TarjetaDTO;
import com.apiBancoSP.bancosp.dto.TransaccionDTO;
import com.apiBancoSP.bancosp.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("tarjeta")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;
    @Autowired
    private JWTUtils jwtUtils;

    @GetMapping
    public ResponseEntity<TarjetaDTO> getDetails(){
        TarjetaDTO tarjeta = tarjetaService.getDetails();
        return ResponseEntity.status(HttpStatus.OK).body(tarjeta);
    }

    @GetMapping("/saldo")
    public ResponseEntity<Double> getSaldo(){

        Double saldo = tarjetaService.getSaldo();
        return ResponseEntity.status(HttpStatus.OK).body(saldo);
    }

    @GetMapping("/transacciones")
    public ResponseEntity<List<TransaccionDTO>> getListTransacciones(){
        List<TransaccionDTO> transacciones = tarjetaService.getTransacciones();
        return ResponseEntity.status(HttpStatus.OK).body(transacciones);
    }
}

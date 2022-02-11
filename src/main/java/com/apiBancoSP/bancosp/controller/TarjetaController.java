package com.apiBancoSP.bancosp.controller;

import com.apiBancoSP.bancosp.auth.service.JWTUtils;
import com.apiBancoSP.bancosp.dto.TarjetaDTO;
import com.apiBancoSP.bancosp.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("tarjeta")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;
    @Autowired
    private JWTUtils jwtUtils;

    @GetMapping
    public ResponseEntity<TarjetaDTO> getDetails(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        TarjetaDTO tarjeta = tarjetaService.getDetails(token);
        return ResponseEntity.status(HttpStatus.OK).body(tarjeta);
    }
}

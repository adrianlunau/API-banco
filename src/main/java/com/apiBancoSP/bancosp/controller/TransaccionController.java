package com.apiBancoSP.bancosp.controller;

import com.apiBancoSP.bancosp.dto.TransaccionDTO;
import com.apiBancoSP.bancosp.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaccion")
public class TransaccionController {

    @Autowired
    private TransaccionService transaccionService;

    @PostMapping
    public ResponseEntity<TransaccionDTO> nuevaTransaccion(@RequestBody TransaccionDTO dto) {
        TransaccionDTO transaccion = transaccionService.transferir(dto);
        return ResponseEntity.ok(transaccion);
    }
}

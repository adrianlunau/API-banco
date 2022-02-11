package com.apiBancoSP.bancosp.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResponse {
    private String jwt;
}

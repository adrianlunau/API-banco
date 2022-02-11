package com.apiBancoSP.bancosp.auth.controller;

import com.apiBancoSP.bancosp.auth.dto.AuthenticationRequest;
import com.apiBancoSP.bancosp.auth.dto.AuthenticationResponse;
import com.apiBancoSP.bancosp.auth.service.JWTUtils;
import com.apiBancoSP.bancosp.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserAuthController {


    private AuthenticationManager authenticationManager;
    private JWTUtils jwtUtils;
    private UserDetailsCustomService userDetailsService;

    @Autowired
    public UserAuthController(UserDetailsCustomService userDetailsService,
                              AuthenticationManager authenticationManager,
                              JWTUtils jwtTokenUtils) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtTokenUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> signin(@RequestBody AuthenticationRequest authRequest) throws Exception {

        UserDetails userDetails;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password");
        }

        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}

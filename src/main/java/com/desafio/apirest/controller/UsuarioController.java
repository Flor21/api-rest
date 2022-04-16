package com.desafio.apirest.controller;

import com.desafio.apirest.config.CustomUserDetailsService;
import com.desafio.apirest.config.JwtUtil;
import com.desafio.apirest.model.AutenticacionRequest;
import com.desafio.apirest.model.AutenticacionResponse;
import com.desafio.apirest.model.UsuarioDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping(path = "/autenticarse", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AutenticacionRequest authenticationRequest)
            throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getNombre(), authenticationRequest.getContrasenia()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        UserDetails userdetails = userDetailsService.loadUserByUsername(authenticationRequest.getContrasenia());
        String token = jwtUtil.generateToken(userdetails);
        return ResponseEntity.ok(new AutenticacionResponse(token));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> saveUser(@RequestBody UsuarioDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

}

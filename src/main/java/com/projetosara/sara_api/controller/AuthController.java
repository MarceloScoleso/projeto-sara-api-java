package com.projetosara.sara_api.controller;

import com.projetosara.sara_api.dto.LoginRequestDTO;
import com.projetosara.sara_api.security.JwtUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Operation(
        summary = "Realiza o login do usuário",
        requestBody = @RequestBody(
            required = true,
            content = @Content(
                schema = @Schema(implementation = LoginRequestDTO.class),
                examples = @ExampleObject(
                    name = "Exemplo de Login",
                    value = """
                        {
                        "username": "Marcelo@email.com",
                        "password": "Marcio12"
                        }
                        """
                )
            )
        )
    )
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @org.springframework.web.bind.annotation.RequestBody LoginRequestDTO request) {
        try {
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
            String token = jwtUtil.generateToken(user);

            return ResponseEntity.ok(new AuthResponse(token));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Usuário ou senha inválidos");
        }
    }

    public record AuthResponse(String token) {}
}
package com.projetosara.sara_api.controller;

import com.projetosara.sara_api.security.JwtUtil;
import jakarta.validation.constraints.NotBlank;
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

    @PostMapping("/login")
public ResponseEntity<?> login(@RequestBody AuthRequest request) {
    try {
    
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));

        
        UserDetails user = userDetailsService.loadUserByUsername(request.username());

        
        String token = jwtUtil.generateToken(user);

        
        return ResponseEntity.ok(new AuthResponse(token));
    } catch (AuthenticationException e) {
        return ResponseEntity.status(401).body("Usuário ou senha inválidos");
    }
}

public record AuthRequest(@NotBlank String username, @NotBlank String password) {}

public record AuthResponse(String token) {}
}

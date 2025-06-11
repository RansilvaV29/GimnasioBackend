package com.espe.gimnasio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.espe.gimnasio.dto.AuthResponseDto;
import com.espe.gimnasio.dto.LoginRequestDto;
import com.espe.gimnasio.dto.UpdateUserRequestDto;
import com.espe.gimnasio.dto.UsuarioDto;
import com.espe.gimnasio.entity.Usuario;
import com.espe.gimnasio.service.AuthService;
import com.espe.gimnasio.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;
    
    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody Usuario usuario) {
        Usuario nuevo = authService.registrar(usuario);
        return ResponseEntity.ok(nuevo);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginRequestDto request) {
        Usuario usuario = authService.autenticar(request.getCorreo(), request.getPassword());
        // Aquí se genera el token 
        String token = jwtService.generateToken(usuario.getCorreo(), usuario.getRol().getNombreRol());
        return ResponseEntity.ok(new AuthResponseDto(token));
    }
    
    
}

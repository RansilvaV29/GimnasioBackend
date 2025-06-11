package com.espe.gimnasio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.espe.gimnasio.dto.UpdateUserRequestDto;
import com.espe.gimnasio.dto.UsuarioDto;
import com.espe.gimnasio.entity.Rol;
import com.espe.gimnasio.entity.Usuario;
import com.espe.gimnasio.repository.RolRepository;
import com.espe.gimnasio.repository.UsuarioRepository;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario registrar(Usuario usuario) {
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticar(String correo, String password) {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, usuario.getContrasena())) {
            throw new BadCredentialsException("Credenciales inválidas");
        }

        return usuario;
    }
    
}

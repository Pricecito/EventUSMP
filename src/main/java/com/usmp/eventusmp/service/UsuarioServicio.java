package com.usmp.eventusmp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.usmp.eventusmp.persistence.models.Usuarios;

@Service
public interface UsuarioServicio extends UserDetailsService {
    void crearUsuario(Usuarios usuario);

    List<Usuarios> listUsuarios();

    Optional<Usuarios> obtenerUsuarioPorId(UUID id);

    void actualizarUsuario(UUID id, Usuarios usuario);

    void eliminarUsuario(UUID id);
}

package com.usmp.eventusmp.persistence.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usmp.eventusmp.persistence.models.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, UUID> {
    Optional<Usuarios> findUsuariosByNombre(String nombre);
}

package com.usmp.eventusmp.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usmp.eventusmp.persistence.models.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, UUID>{

}

package com.usmp.eventusmp.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usmp.eventusmp.persistence.models.Registros;

public interface RegistrosRepository extends JpaRepository<Registros, UUID> {

}

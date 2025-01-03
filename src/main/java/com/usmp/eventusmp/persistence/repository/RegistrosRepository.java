package com.usmp.eventusmp.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usmp.eventusmp.persistence.models.Registros;
@Repository
public interface RegistrosRepository extends JpaRepository<Registros, UUID> {

}

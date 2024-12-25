package com.usmp.eventusmp.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usmp.eventusmp.persistence.models.Eventos;

@Repository
public interface EventosRepository extends JpaRepository<Eventos, UUID> {

}

package com.usmp.eventusmp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usmp.eventusmp.persistence.models.Permisos;

@Repository
public interface PermisosRepository extends JpaRepository<Permisos, Long> {

}

package com.usmp.eventusmp.persistence.repository;

import com.usmp.eventusmp.persistence.models.Categorias;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, UUID> {


}

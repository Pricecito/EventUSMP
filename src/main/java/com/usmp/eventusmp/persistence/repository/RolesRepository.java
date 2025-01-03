package com.usmp.eventusmp.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usmp.eventusmp.persistence.models.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

}

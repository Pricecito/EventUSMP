package com.usmp.eventusmp;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.usmp.eventusmp.persistence.models.Permisos;
import com.usmp.eventusmp.persistence.models.PermisosEnum;
import com.usmp.eventusmp.persistence.models.RoleEnum;
import com.usmp.eventusmp.persistence.models.Roles;
import com.usmp.eventusmp.persistence.models.Usuarios;
import com.usmp.eventusmp.persistence.repository.UsuariosRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EventusmpApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventusmpApplication.class, args);
	}

	@Bean

	CommandLineRunner init(UsuariosRepository userRepository) {
		return args -> {

			// INSERCION DE PERMISOS
			log.info("Insertando permisos");
			Permisos permisoCrear = Permisos.builder()
					.permisosEnum(PermisosEnum.CREAR).build();
			Permisos permisoEditar = Permisos.builder()
					.permisosEnum(PermisosEnum.EDITAR).build();
			Permisos permisoEliminar = Permisos.builder()
					.permisosEnum(PermisosEnum.ELIMINAR).build();
			Permisos permisoVer = Permisos.builder()
					.permisosEnum(PermisosEnum.VER).build();

			// INSERCION DE ROLES
			log.info("Insertando roles");
			Roles rolDesarrollador = Roles.builder()
					.rolesEnum(RoleEnum.DESARROLLADOR)
					.permisosList(Set.of(permisoCrear, permisoEditar, permisoEliminar, permisoVer))
					.build();
			Roles rolUsuario = Roles.builder()
					.rolesEnum(RoleEnum.USUARIO)
					.permisosList(Set.of(permisoVer))
					.build();
			Roles rolAdministrador = Roles.builder()
					.rolesEnum(RoleEnum.ADMINISTRADOR)
					.permisosList(Set.of(permisoCrear, permisoEditar, permisoEliminar, permisoVer))
					.build();

			// INSERCION DE USUARIOS
			Usuarios userMatias = Usuarios.builder()
					.nombre("Matias")
					.email("matias.gutierrez@gmail.com")
					.contrasena("$2a$10$ivZUFz5zrdxTqvbK94v.p.4H2DU1.MEMrKshn8bPzeLPowQt2KejO")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(rolAdministrador, rolDesarrollador))
					.build();
			Usuarios userPueba = Usuarios.builder()
					.nombre("Prueba")
					.email("prueba@gmail.com")
					.contrasena("$2a$10$ivZUFz5zrdxTqvbK94v.p.4H2DU1.MEMrKshn8bPzeLPowQt2KejO")
					.isEnabled(true)
					.accountNoExpired(true)
					.accountNoLocked(true)
					.credentialNoExpired(true)
					.roles(Set.of(rolUsuario))
					.build();

			userRepository.saveAll(List.of(userMatias, userPueba));

		};
	}

}

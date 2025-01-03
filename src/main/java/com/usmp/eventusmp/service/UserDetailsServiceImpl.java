package com.usmp.eventusmp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.usmp.eventusmp.persistence.models.Usuarios;
import com.usmp.eventusmp.persistence.repository.UsuariosRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

        @Autowired
        private UsuariosRepository usuariosRepository;

        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                Usuarios usuario = usuariosRepository.findUsuariosByEmail(
                                email)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "Usuario " + email + " no encontrado"));

                List<SimpleGrantedAuthority> authorities = new ArrayList<>();

                usuario.getRoles()
                                .forEach(
                                                rol -> authorities.add(new SimpleGrantedAuthority(
                                                                "ROLE_".concat(rol.getRolesEnum().name()))));

                usuario.getRoles()
                                .stream()
                                .flatMap(rol -> rol.getPermisosList().stream())
                                .forEach(permiso -> authorities
                                                .add(new SimpleGrantedAuthority(permiso.getPermisosEnum().name())));

                return new User(usuario.getNombre(),
                                usuario.getContrasena(),
                                usuario.isEnabled(),
                                usuario.isAccountNoExpired(),
                                usuario.isAccountNoLocked(),
                                usuario.isCredentialNoExpired(),
                                authorities);
        }
}

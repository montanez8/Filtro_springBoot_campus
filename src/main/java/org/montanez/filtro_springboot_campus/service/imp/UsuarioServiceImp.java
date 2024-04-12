package org.montanez.filtro_springboot_campus.service.imp;


import org.montanez.filtro_springboot_campus.repository.RoleRepository;
import org.montanez.filtro_springboot_campus.repository.UsuarioRepositiry;
import org.montanez.filtro_springboot_campus.repository.entities.Rol;
import org.montanez.filtro_springboot_campus.repository.entities.Usuario;
import org.montanez.filtro_springboot_campus.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepositiry usuarioRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    @Transactional
    public Usuario save(Usuario user) {

        List<Rol> roles = new ArrayList<>();

        if (user.isAdmin()) {
            Optional<Rol> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }

        if (user.isUser()) {
            Optional<Rol> optionalRoleDirector = roleRepository.findByName("ROLE_USER");
            optionalRoleDirector.ifPresent(roles::add);
        }

        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return usuarioRepository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return usuarioRepository.existsByUsername(username);
    }
}

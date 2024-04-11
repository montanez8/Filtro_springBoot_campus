package org.montanez.filtro_springboot_campus.repository;


import org.montanez.filtro_springboot_campus.repository.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositiry extends JpaRepository<Usuario, Long> {

    boolean existsByUsername(String username);

    Optional<Usuario> findByUsername(String username);
}

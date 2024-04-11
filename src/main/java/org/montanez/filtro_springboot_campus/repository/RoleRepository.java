package org.montanez.filtro_springboot_campus.repository;


import org.montanez.filtro_springboot_campus.repository.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Rol, Long> {
    Optional<Rol> findByName(String name);

}

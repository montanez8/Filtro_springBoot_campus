package org.montanez.filtro_springboot_campus.repository;

import org.montanez.filtro_springboot_campus.repository.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente , Long> {

}

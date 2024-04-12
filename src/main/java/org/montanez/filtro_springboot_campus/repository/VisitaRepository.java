package org.montanez.filtro_springboot_campus.repository;

import org.montanez.filtro_springboot_campus.repository.entities.Visita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitaRepository extends JpaRepository<Visita, Long> {
}

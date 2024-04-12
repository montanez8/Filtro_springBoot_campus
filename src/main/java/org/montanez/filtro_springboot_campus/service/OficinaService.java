package org.montanez.filtro_springboot_campus.service;

import java.util.List;
import java.util.Optional;

import org.montanez.filtro_springboot_campus.dto.OficinaDto;

public interface OficinaService {

    List<OficinaDto> findAll();

    Optional<OficinaDto> findByid(Long id);

    OficinaDto save (OficinaDto oficina);

    Optional<String> update(Long id , OficinaDto oficina);

    Optional<String> delete(Long id);
}

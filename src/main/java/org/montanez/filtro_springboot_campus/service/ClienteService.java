package org.montanez.filtro_springboot_campus.service;

import java.util.List;
import java.util.Optional;

import org.montanez.filtro_springboot_campus.dto.ClienteDto;

public interface ClienteService {

    List<ClienteDto> findAll();

    Optional<ClienteDto> findById(Long id);

    ClienteDto save(ClienteDto cliente);

    Optional<String> update(Long id, ClienteDto cliente);

    Optional<String> delete(Long id);

}

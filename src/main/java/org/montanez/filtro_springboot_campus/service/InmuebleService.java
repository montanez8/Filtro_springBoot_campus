package org.montanez.filtro_springboot_campus.service;

import java.util.Optional;

import org.montanez.filtro_springboot_campus.dto.InmuebleDto;


public interface InmuebleService {

    Optional<InmuebleDto> findByReferencia(int numeroReferencia);

    InmuebleDto save(InmuebleDto inmueble);


}

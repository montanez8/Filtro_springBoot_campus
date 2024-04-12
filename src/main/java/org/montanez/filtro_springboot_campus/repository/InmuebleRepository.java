package org.montanez.filtro_springboot_campus.repository;

import java.util.List;
import java.util.Optional;

import org.montanez.filtro_springboot_campus.repository.entities.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long>{

    Inmueble findByReferencia(int referencia);
    List<Inmueble> findByOferta(String oferta);

}

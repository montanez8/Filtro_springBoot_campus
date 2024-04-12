package org.montanez.filtro_springboot_campus.service.imp;

import java.util.Optional;

import org.montanez.filtro_springboot_campus.dto.InmuebleDto;
import org.montanez.filtro_springboot_campus.service.InmuebleService;
import org.springframework.stereotype.Service;
@Service
public class InmuebleServieceImp implements InmuebleService{

    @Override
    public Optional<InmuebleDto> findByReferencia(int numeroReferencia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByReferencia'");
    }

    @Override
    public InmuebleDto save(InmuebleDto inmueble) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

}

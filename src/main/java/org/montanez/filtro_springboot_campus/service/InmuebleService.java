package org.montanez.filtro_springboot_campus.service;

import java.util.List;

import org.montanez.filtro_springboot_campus.dto.*;


public interface InmuebleService {

    PisoNuevoDto savePisoNuevo(PisoNuevoDto pisoNuevoDto);
    PisoOcasionDto savePisoOcasion(PisoOcasionDto pisoOcasionDto);
    VillaDto saveVilla(VillaDto villaDto);
    CasaDto saveCasa(CasaDto casaDto);
    LocalDto saveLocal(LocalDto localDto);
    InmuebleDto save(InmuebleDto inmuebleDto);
    InmuebleDto findByReferencia(int referencia);
    List<InmuebleDto> getInmueblesByOferta(String oferta);
    VisitaDto createVisita(VisitaDto visitaDto);

}

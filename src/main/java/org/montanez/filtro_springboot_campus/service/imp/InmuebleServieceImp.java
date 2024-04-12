package org.montanez.filtro_springboot_campus.service.imp;


import java.util.List;

import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import org.montanez.filtro_springboot_campus.dto.*;
import org.montanez.filtro_springboot_campus.dto.dto_converter.*;
import org.montanez.filtro_springboot_campus.exeption.ResourceNotFoundException;
import org.montanez.filtro_springboot_campus.repository.ClienteRepository;
import org.montanez.filtro_springboot_campus.repository.InmuebleRepository;
import org.montanez.filtro_springboot_campus.repository.VisitaRepository;
import org.montanez.filtro_springboot_campus.repository.entities.Cliente;
import org.montanez.filtro_springboot_campus.repository.entities.Inmueble;
import org.montanez.filtro_springboot_campus.repository.entities.Visita;
import org.montanez.filtro_springboot_campus.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InmuebleServieceImp implements InmuebleService {


    private final InmuebleDtoConvert inmuebleDtoConvert;
    private final InmuebleRepository inmuebleRepository;
    private final ClienteRepository clienteRepository;
    private final VisitaDtoConverter visitaDtoConverter;
    private final VisitaRepository visitaRepository;
    private final PisoNuevoDtoConvert pisoNuevoDtoConvert;
    private final PisoOcasionDtoConvert pisoOcasionDtoConvert;
    private final VillaDtoConvert villaDtoConvert;
    private final CasaDtoConvert casaDtoConvert;
    private final LocalDtoConvert localDtoConvert;



    @Override
    public InmuebleDto save(InmuebleDto inmuebleDto) {
        Inmueble inmueble = inmuebleDtoConvert.converToEntity(inmuebleDto);
        return inmuebleDtoConvert.converToDto(inmuebleRepository.save(inmueble));
    }

    public InmuebleDto findByReferencia(int referencia) {
        Inmueble inmueble = inmuebleRepository.findByReferencia(referencia);
        if (inmueble == null) {
            throw new RuntimeException("Inmueble no encontrado");
        }
        return inmuebleDtoConvert.converToDto(inmueble);
    }

    @Override
    public List<InmuebleDto> getInmueblesByOferta(String oferta) {
        List<Inmueble> inmuebles = inmuebleRepository.findByOferta(oferta);
        return inmuebles.stream()
                .map(inmuebleDtoConvert::converToDto)
                .collect(Collectors.toList());
    }

    @Override
public VisitaDto createVisita(VisitaDto visitaDto) {
    Inmueble inmueble = inmuebleRepository.findById(visitaDto.getInmuebleId())
        .orElseThrow(() -> new ResourceNotFoundException("Inmueble", "id", visitaDto.getInmuebleId()));
    Cliente cliente = clienteRepository.findById(visitaDto.getClienteId())
        .orElseThrow(() -> new ResourceNotFoundException("Cliente", "id", visitaDto.getClienteId()));
    Visita visita = new Visita();
    visita.setFechaVisita(visitaDto.getFechaVisita());
    visita.setInmueble(inmueble);
    visita.setCliente(cliente);
    visita.setComentario(visitaDto.getComentario());
    visita = visitaRepository.save(visita);
    return visitaDtoConverter.convertToDto(visita);
}


    @Override
    public PisoNuevoDto savePisoNuevo(PisoNuevoDto pisoNuevoDto) {
        pisoNuevoDto.setId(null);
        Inmueble inmueble = pisoNuevoDtoConvert.converToEntity(pisoNuevoDto);
        inmueble.setTipoInmueble("Piso Nuevo");
        return pisoNuevoDtoConvert.converToDto(inmuebleRepository.save(inmueble));
    }
    @Override
    public PisoOcasionDto savePisoOcasion(PisoOcasionDto pisoOcasionDto) {
        pisoOcasionDto.setId(null);
        Inmueble inmueble = pisoOcasionDtoConvert.converToEntity(pisoOcasionDto);
        inmueble.setTipoInmueble("Piso Ocasión");
        return pisoOcasionDtoConvert.converToDto(inmuebleRepository.save(inmueble));
    }

    @Override
    public VillaDto saveVilla(VillaDto villaDto) {
       villaDto.setId(null);
        Inmueble inmueble = villaDtoConvert.converToEntity(villaDto);
        inmueble.setTipoInmueble("Villa");
        return villaDtoConvert.converToDto(inmuebleRepository.save(inmueble));
    }

    @Override
    public CasaDto saveCasa(CasaDto casaDto) {
        casaDto.setId(null);
        Inmueble inmueble = casaDtoConvert.converToEntity(casaDto);
        inmueble.setTipoInmueble("Casa");
        return casaDtoConvert.converToDto(inmuebleRepository.save(inmueble));
    }

    @Override
    public LocalDto saveLocal(LocalDto localDto) {
        localDto.setId(null);
        Inmueble inmueble = localDtoConvert.converToEntity(localDto);
        inmueble.setTipoInmueble("Local");
        return localDtoConvert.converToDto(inmuebleRepository.save(inmueble));
    }



}

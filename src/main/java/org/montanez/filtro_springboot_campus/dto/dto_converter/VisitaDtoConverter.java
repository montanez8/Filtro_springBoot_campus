package org.montanez.filtro_springboot_campus.dto.dto_converter;

import org.modelmapper.ModelMapper;
import org.montanez.filtro_springboot_campus.dto.VisitaDto;
import org.montanez.filtro_springboot_campus.repository.entities.Visita;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VisitaDtoConverter {

    private ModelMapper modelMapper;

    public VisitaDto convertToDto(Visita visita){
        return modelMapper.map(visita, VisitaDto.class);
    }

    public Visita convertToEntity(VisitaDto visitaDto){
        return modelMapper.map(visitaDto, Visita.class);
    }

}

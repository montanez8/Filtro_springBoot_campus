package org.montanez.filtro_springboot_campus.dto.dto_converter;

import org.modelmapper.ModelMapper;
import org.montanez.filtro_springboot_campus.dto.PisoNuevoDto;
import org.montanez.filtro_springboot_campus.repository.entities.Inmueble;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PisoNuevoDtoConvert {

    private ModelMapper modelMapper;

    public PisoNuevoDto converToDto(Inmueble inmueble){
        return modelMapper.map(inmueble, PisoNuevoDto.class);
    }

    public Inmueble converToEntity(PisoNuevoDto pisoNuevoDto){
        return modelMapper.map(pisoNuevoDto, Inmueble.class);
    }

}

package org.montanez.filtro_springboot_campus.dto.dto_converter;

import org.modelmapper.ModelMapper;
import org.montanez.filtro_springboot_campus.dto.PisoOcasionDto;
import org.montanez.filtro_springboot_campus.repository.entities.Inmueble;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PisoOcasionDtoConvert {

    private ModelMapper modelMapper;

    public PisoOcasionDto converToDto(Inmueble inmueble){
        return modelMapper.map(inmueble, PisoOcasionDto.class);
    }

    public Inmueble converToEntity(PisoOcasionDto pisoOcasionDto){
        return modelMapper.map(pisoOcasionDto, Inmueble.class);
    }

}

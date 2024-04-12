package org.montanez.filtro_springboot_campus.dto.dto_converter;

import org.modelmapper.ModelMapper;
import org.montanez.filtro_springboot_campus.dto.CasaDto;
import org.montanez.filtro_springboot_campus.repository.entities.Inmueble;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CasaDtoConvert {

    private ModelMapper modelMapper;

    public CasaDto converToDto(Inmueble inmueble){
        return modelMapper.map(inmueble, CasaDto.class);
    }

    public Inmueble converToEntity(CasaDto casaDto){
        return modelMapper.map(casaDto, Inmueble.class);
    }

}

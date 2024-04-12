package org.montanez.filtro_springboot_campus.dto.dto_converter;

import org.modelmapper.ModelMapper;
import org.montanez.filtro_springboot_campus.dto.LocalDto;
import org.montanez.filtro_springboot_campus.repository.entities.Inmueble;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LocalDtoConvert {

    private ModelMapper modelMapper;

    public LocalDto converToDto(Inmueble inmueble){
        return modelMapper.map(inmueble, LocalDto.class);
    }

    public Inmueble converToEntity(LocalDto localDto){
        return modelMapper.map(localDto, Inmueble.class);
    }

}

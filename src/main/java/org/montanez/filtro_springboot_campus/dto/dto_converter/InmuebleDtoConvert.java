package org.montanez.filtro_springboot_campus.dto.dto_converter;

import org.modelmapper.ModelMapper;
import org.montanez.filtro_springboot_campus.dto.InmuebleDto;
import org.montanez.filtro_springboot_campus.repository.entities.Inmueble;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class InmuebleDtoConvert {

    private ModelMapper modelMapper;

    public InmuebleDto converToDto(Inmueble inmueble){
        return modelMapper.map(inmueble, InmuebleDto.class);
    }

    public Inmueble converToEntity(InmuebleDto inmuebleDto){
        return modelMapper.map(inmuebleDto,Inmueble.class );
    }

}

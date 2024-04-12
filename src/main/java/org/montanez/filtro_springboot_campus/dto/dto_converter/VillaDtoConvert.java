package org.montanez.filtro_springboot_campus.dto.dto_converter;

import org.modelmapper.ModelMapper;
import org.montanez.filtro_springboot_campus.dto.VillaDto;
import org.montanez.filtro_springboot_campus.repository.entities.Inmueble;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class VillaDtoConvert {

    private ModelMapper modelMapper;

    public VillaDto converToDto(Inmueble inmueble){
        return modelMapper.map(inmueble, VillaDto.class);
    }

    public Inmueble converToEntity(VillaDto villaDto){
        return modelMapper.map(villaDto, Inmueble.class);
    }

}

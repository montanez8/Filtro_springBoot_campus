package org.montanez.filtro_springboot_campus.dto.dto_converter;

import org.modelmapper.ModelMapper;
import org.montanez.filtro_springboot_campus.dto.OficinaDto;
import org.montanez.filtro_springboot_campus.repository.entities.Oficina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OficinaDtoConverter {

    @Autowired
    private ModelMapper modelMapper;

    public Oficina convertToEntity(OficinaDto oficinaDto){
        return modelMapper.map(oficinaDto,Oficina.class);
    }

    public OficinaDto converDto(Oficina oficina){
        return modelMapper.map(oficina, OficinaDto.class);
    }


}

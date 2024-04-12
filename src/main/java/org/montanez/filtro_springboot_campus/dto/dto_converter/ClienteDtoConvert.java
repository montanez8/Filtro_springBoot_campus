package org.montanez.filtro_springboot_campus.dto.dto_converter;

import org.modelmapper.ModelMapper;
import org.montanez.filtro_springboot_campus.dto.ClienteDto;
import org.montanez.filtro_springboot_campus.repository.entities.Cliente;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ClienteDtoConvert {

    private ModelMapper modelMapper;

    public ClienteDto converToDto(Cliente cliente){
        return modelMapper.map(cliente, ClienteDto.class);
    }

    public Cliente converToEntity(ClienteDto clienteDto){
        return modelMapper.map(clienteDto,Cliente.class );
    }

}

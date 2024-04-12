package org.montanez.filtro_springboot_campus.service.imp;

import java.util.List;
import java.util.Optional;
import org.montanez.filtro_springboot_campus.dto.ClienteDto;
import org.montanez.filtro_springboot_campus.dto.dto_converter.ClienteDtoConvert;
import org.montanez.filtro_springboot_campus.repository.ClienteRepository;
import org.montanez.filtro_springboot_campus.repository.entities.Cliente;
import org.montanez.filtro_springboot_campus.service.ClienteService;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class ClienteServiceImp implements ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteDtoConvert clienteDtoConvert;
    

    @Override
    public List<ClienteDto> findAll() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
        .map(clienteDtoConvert::converToDto).toList();
    }

    @Override
    public Optional<ClienteDto> findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            return Optional.empty();
        }
        return cliente.map(clienteDtoConvert::converToDto);
    }

    @Override
    @Transactional
    public ClienteDto save(ClienteDto clienteDto) {
       return clienteDtoConvert
       .converToDto(clienteRepository
       .save(clienteDtoConvert
       .converToEntity(clienteDto)));

    }

    @Override
    @Transactional
    public Optional<String> update(Long id, ClienteDto cliente) {
        Cliente clienteExits = clienteRepository.findById(id)
        .orElseThrow(()-> new EntityNotFoundException("cliente con  id " + id + "no encontrado"));
        clienteExits.setNombre(cliente.getNombre());
        clienteExits.setNumeroDocumento(cliente.getNumeroDocumento());
        clienteExits.setTelefono(cliente.getNombre());
        clienteExits.setEmail(cliente.getEmail());
        clienteRepository.save(clienteExits);
        return Optional.of("Cliente actualizado con exito");

    }

    @Override
    @Transactional
    public Optional<String> delete(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
            clienteRepository.deleteById(id);
            return Optional.of("Cliente eliminado con exito");
        }
        return Optional.of("Cliente no Encontrado");
    }

}

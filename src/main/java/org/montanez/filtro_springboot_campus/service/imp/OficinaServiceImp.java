package org.montanez.filtro_springboot_campus.service.imp;

import java.util.List;
import java.util.Optional;

import org.montanez.filtro_springboot_campus.dto.OficinaDto;
import org.montanez.filtro_springboot_campus.dto.dto_converter.OficinaDtoConverter;
import org.montanez.filtro_springboot_campus.repository.OficinaRepository;
import org.montanez.filtro_springboot_campus.repository.entities.Oficina;
import org.montanez.filtro_springboot_campus.service.OficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;


@Service
public class OficinaServiceImp implements OficinaService {

    @Autowired
    private OficinaRepository oficinaRepository;
    @Autowired
    private OficinaDtoConverter oficinaDtoConverter;

    @Override
    public List<OficinaDto> findAll() {
        List<Oficina> oficinas = oficinaRepository.findAll();
        return oficinas.stream()
                .map(oficinaDtoConverter::converDto).toList();
    }

    @Override
    public Optional<OficinaDto> findByid(Long id) {
        Optional<Oficina> oficina = oficinaRepository.findById(id);
        if (oficina.isPresent()) {
            return Optional.empty();
        }
        return oficina.map(oficinaDtoConverter::converDto);
    }

    @Override
    @Transactional
    public OficinaDto save(OficinaDto oficina) {
        return oficinaDtoConverter
                .converDto(oficinaRepository.save(oficinaDtoConverter.convertToEntity(oficina)));
    }

    @Override
    @Transactional
    public Optional<String> update(Long id, OficinaDto oficina) {
        Oficina oficinaExist = oficinaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Oficina con id " + id + "No encomtrada"));
        oficinaExist.setNombre(oficina.getNombre());
        oficinaExist.setDireccion(oficina.getDireccion());
        oficinaExist.setTelefono(oficina.getTelefono());
        oficinaRepository.save(oficinaExist);
        return Optional.of("Oficina Actualizada con Exito");

    }

    @Override
    @Transactional
    public Optional<String> delete(Long id) {
        Optional<Oficina> oficina = oficinaRepository.findById(id);
        if (oficina.isPresent()) {
            oficinaRepository.deleteById(id);
            return Optional.of("oficina eliminado con exito");
        }
        return Optional.of("oficina no Encontrado");
    }

}

package org.montanez.filtro_springboot_campus.controller;

import java.util.List;
import java.util.Optional;

import org.montanez.filtro_springboot_campus.dto.OficinaDto;
import org.montanez.filtro_springboot_campus.service.OficinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(("api/oficina"))
@PreAuthorize("hasRole('ADMIN')")
public class OficinaController {
    @Autowired
    private OficinaService oficinaService;
@GetMapping
    @Operation(summary = "Listar todos los clientes")
    public List<OficinaDto> listar() {
        return oficinaService.findAll();
    }

    @Operation(summary = "Obtener Cliente por Id")
    @GetMapping("/{id}")
    public ResponseEntity<?> oficinaById(@PathVariable Long id) {
        Optional<OficinaDto> oficinaDOptional = oficinaService.findByid(id);
        if (oficinaDOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontro la oficina con id: " + id + "solicitado");
        }
        return oficinaDOptional.map(o -> ResponseEntity.status(HttpStatus.OK).body(o))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED).build());
    }

    @PostMapping()
    @Operation(summary = "Crear una nueva oficina")
    public ResponseEntity<?> save(OficinaDto oficina) {
        return ResponseEntity.status(HttpStatus.CREATED).body(oficinaService.save(oficina));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actulizar datos de una oficina especificada")
    public ResponseEntity<?> update(@PathVariable Long id, OficinaDto cliente) {
        return oficinaService.update(id, cliente).map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}") // http://localhost:8080/api/voluntario/id
    @Operation(summary = "Eliminar Oficina")
    public ResponseEntity<String> deleteVoluntario(@PathVariable Long id) {
        Optional<String> result = oficinaService.delete(id);
        return ResponseEntity.ok(result.get());
    }


}

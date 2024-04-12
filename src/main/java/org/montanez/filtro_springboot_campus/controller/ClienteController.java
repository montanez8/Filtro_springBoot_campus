package org.montanez.filtro_springboot_campus.controller;

import java.util.List;
import java.util.Optional;

import org.montanez.filtro_springboot_campus.dto.ClienteDto;
import org.montanez.filtro_springboot_campus.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(("api/cliente"))
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    @Operation(summary = "Listar todos los clientes")
    public List<ClienteDto> listar() {
        return clienteService.findAll();
    }

    @Operation(summary = "Obtener Cliente por Id")
    @GetMapping("/{id}")
    public ResponseEntity<?> clienteById(@PathVariable Long id) {
        Optional<ClienteDto> clienteDto = clienteService.findById(id);
        if (clienteDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontro el cliente con id: " + id + "solicitado");
        }
        return clienteDto.map(o -> ResponseEntity.status(HttpStatus.OK).body(o))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.CREATED).build());
    }

    @PostMapping()
    @Operation(summary = "Crear un nuevo Cliente")
    public ResponseEntity<?> save(ClienteDto cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un Cliente especificado")
    public ResponseEntity<?> update(@PathVariable Long id, ClienteDto cliente) {
        return clienteService.update(id, cliente).map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND));
    }

}

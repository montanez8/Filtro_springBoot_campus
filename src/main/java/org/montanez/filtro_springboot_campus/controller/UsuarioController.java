package org.montanez.filtro_springboot_campus.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.montanez.filtro_springboot_campus.repository.entities.Usuario;
import org.montanez.filtro_springboot_campus.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping // http://localhost:8080/api/usuario
    public List<Usuario> list() {
        return usuarioService.findAll();
    }

     @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody Usuario user,
            BindingResult result) {
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(user));
    }

    @PostMapping("/register") // http://localhost:8080/api/usuario/register
    public ResponseEntity<?> register(@Valid @RequestBody Usuario user,
            BindingResult result) {
        user.setAdmin(false);
        return create(user, result);
    }

    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " +
                    err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}

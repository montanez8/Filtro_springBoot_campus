package org.montanez.filtro_springboot_campus.service;



import org.montanez.filtro_springboot_campus.repository.entities.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();

    Usuario save(Usuario user);

    boolean existsByUsername(String username);

}

package org.montanez.filtro_springboot_campus.repository.models;

import lombok.Data;

@Data
public class JWTRequest {

    private String username;
    private String password;
}

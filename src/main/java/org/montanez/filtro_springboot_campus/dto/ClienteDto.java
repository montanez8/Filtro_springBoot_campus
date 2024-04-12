package org.montanez.filtro_springboot_campus.dto;

import lombok.Data;

@Data
public class ClienteDto {
    private String nombre;
    private String numeroDocumento;
    private String telefono;
    private String email;
}

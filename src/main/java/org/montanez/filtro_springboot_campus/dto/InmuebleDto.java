package org.montanez.filtro_springboot_campus.dto;

import org.montanez.filtro_springboot_campus.repository.entities.TipoInmueble;

import lombok.Data;

@Data
public class InmuebleDto {
 private TipoInmueble tipo;
    private Double superficie;
    private String direccion;
    private String numeroReferencia;
    private double tamanioParcela;
    private String uranizacion;
    private double precio;
    private boolean llaves;
}

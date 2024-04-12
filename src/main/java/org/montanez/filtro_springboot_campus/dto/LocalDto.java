package org.montanez.filtro_springboot_campus.dto;

import lombok.Data;

@Data
public class LocalDto {
    private Long id;
    private int referencia;
    private Double superficie;
    private String direccionCompleta;
    private String zonaCiudad;
    private Integer numPuertasEntrada;
    private Boolean diafano;
    private Boolean acondicionado;
    private Double precioVenta;
    private Double precioAlquiler;
    private Long propietarioId;
    private Long oficinaId;
}

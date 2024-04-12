package org.montanez.filtro_springboot_campus.dto;

import lombok.Data;

@Data
public class PisoNuevoDto {
    private Long id;
    private int referencia;
    private Double superficie;
    private String direccionCompleta;
    private String zonaCiudad;
    private Double precioVenta;
    private Double precioAlquiler;
    private String tipoInmueble;
    private Integer numHabitaciones;
    private Integer numBanos;
    private Boolean gasCiudad;
    private Boolean puertaBlindada;
    private Boolean parquet;
    private Long propietarioId;
    private Long oficinaId;
}

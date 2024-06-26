package org.montanez.filtro_springboot_campus.dto;

import lombok.Data;

@Data
public class InmuebleDto {
    private Long id;
    private int referencia;
    private Double superficie;
    private String direccionCompleta;
    private String zonaCiudad;
    private Double precioVenta;
    private Double precioAlquiler;
    private String oferta;
    private String tipoInmueble;
    private Integer numHabitaciones;
    private Integer numBanos;
    private Boolean gasCiudad;
    private Boolean puertaBlindada;
    private Boolean parquet;
    private Double tamanoParcela;
    private String urbanizacion;
    private Long propietarioId;
    private Long oficinaId;
}

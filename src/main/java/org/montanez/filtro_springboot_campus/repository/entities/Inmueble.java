package org.montanez.filtro_springboot_campus.repository.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "inmueble")
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int referencia;
    private Double superficie;
    @Column(name = "direccion_completa")
    private String direccionCompleta;
    @Column(name = "zona_ciudad")
    private String zonaCiudad;
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Column(name = "precio_alquiler")
    private Double precioAlquiler;
    private String oferta;
    @Column(name = "tipo_inmueble")
    private String tipoInmueble;
    @Column(name ="numero_habitaciones" )// Piso, Villa, Casa, etc.
    private Integer numHabitaciones;
    @Column(name = "numero_banos")
    private Integer numBanos;
    @Column(name = "gas_ciudad")
    private Boolean gasCiudad;
    @Column(name = "puerta_blindada")
    private Boolean puertaBlindada;
    private Boolean parquet;
    @Column(name = "tamano_parcela")
    private Double tamanoParcela; // Solo para Villas
    private String urbanizacion; // Solo para Villas

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    @ManyToOne
    @JoinColumn(name = "oficina_id")
    private Oficina oficina;

    @OneToMany(mappedBy = "inmueble")
    private List<Visita> visitas;

}

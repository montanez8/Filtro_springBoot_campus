package org.montanez.filtro_springboot_campus.repository.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoInmueble tipo;
    private Double superficie;
    private String direccion;
    private String numeroReferencia;
    private double tamanioParcela;
    private String uranizacion;
    private double precio;
    private boolean llaves;
    
    @OneToOne(mappedBy = "inmueble")
    private Oficina oficina;
    @OneToOne(mappedBy = "inmueble")
    private Propietario propietario;
    @OneToOne(mappedBy = "inmueble")
    private Visita visita;

}

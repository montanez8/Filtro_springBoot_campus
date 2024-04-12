package org.montanez.filtro_springboot_campus.repository.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "oficina")
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;

    @OneToMany(mappedBy = "oficina")
    private List<Inmueble> inmuebles;

    @OneToMany(mappedBy = "oficina")
    private List<Llave> llaves;
}

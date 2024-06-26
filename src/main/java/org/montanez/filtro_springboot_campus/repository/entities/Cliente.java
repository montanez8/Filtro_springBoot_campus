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
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String numeroDocumento;
    private String telefono;
    private String email;

    @OneToMany(mappedBy = "cliente")
    private List<Visita> visitas;
}

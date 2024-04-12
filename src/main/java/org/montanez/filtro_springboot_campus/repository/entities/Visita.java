package org.montanez.filtro_springboot_campus.repository.entities;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    private Inmueble inmueble;
    private Cliente cliente ;
    private LocalDate fechaVisita;
    private LocalDate hora;
    private String Comentario;
    
    
}

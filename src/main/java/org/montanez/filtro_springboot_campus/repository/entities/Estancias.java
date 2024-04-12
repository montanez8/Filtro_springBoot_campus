package org.montanez.filtro_springboot_campus.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class Estancias {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numeroHabitaciones;
    private int numeroBanios;
    private int numeroAseos;
    private int numeroCocinas;
    private int numeroPuertasEntrada;
    private String zonaCiudad;
    private boolean gas;
    private boolean puertaBrindada;
    private boolean diafano;
    private boolean acondicionado;


}

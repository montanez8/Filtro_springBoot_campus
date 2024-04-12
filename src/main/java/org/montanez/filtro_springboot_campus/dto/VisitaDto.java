package org.montanez.filtro_springboot_campus.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class VisitaDto {
    private Long id;
    private LocalDateTime fechaVisita;
    private Long inmuebleId;
    private Long clienteId;
    private String comentario;
}

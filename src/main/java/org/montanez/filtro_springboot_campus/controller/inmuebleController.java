package org.montanez.filtro_springboot_campus.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import org.montanez.filtro_springboot_campus.dto.*;
import org.montanez.filtro_springboot_campus.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping(("api/inmueble"))
public class inmuebleController {


    @PostMapping("/pisoNuevo")
    public ResponseEntity<PisoNuevoDto> createPisoNuevo(@RequestBody PisoNuevoDto pisoNuevoDto) {
        return ResponseEntity.ok(inmuebleService.savePisoNuevo(pisoNuevoDto));
    }

    @PostMapping("/pisoOcasion")
    public ResponseEntity<PisoOcasionDto> createPisoOcasion(@RequestBody PisoOcasionDto pisoOcasionDto) {
        return ResponseEntity.ok(inmuebleService.savePisoOcasion(pisoOcasionDto));
    }


    @PostMapping("/villa")
    public ResponseEntity<VillaDto> createVilla(@RequestBody VillaDto villaDto) {
        return ResponseEntity.ok(inmuebleService.saveVilla(villaDto));
    }

    @PostMapping("/casa")
    public ResponseEntity<CasaDto> createCasa(@RequestBody CasaDto casaDto) {
        return ResponseEntity.ok(inmuebleService.saveCasa(casaDto));
    }

    @PostMapping("/local")
    public ResponseEntity<LocalDto> createLocal(@RequestBody LocalDto localDto) {
        return ResponseEntity.ok(inmuebleService.saveLocal(localDto));
    }

    @Autowired
    private InmuebleService inmuebleService;
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/referencia/{referencia}")
    public ResponseEntity<InmuebleDto> getByReferencia(@PathVariable int referencia) {
        return ResponseEntity.ok(inmuebleService.findByReferencia(referencia));
    }

    @GetMapping("/oferta/{oferta}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<InmuebleDto> getInmueblesByOferta(@PathVariable @Schema(allowableValues = {
            "Venta", "Alquiler"}) String oferta) {
        return inmuebleService.getInmueblesByOferta(oferta);
    }

    @PostMapping("/visitas")
    public VisitaDto createVisita(@RequestBody VisitaDto visitaDto) {
        return inmuebleService.createVisita(visitaDto);
    }

}

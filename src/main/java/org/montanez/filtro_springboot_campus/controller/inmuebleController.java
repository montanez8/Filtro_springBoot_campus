package org.montanez.filtro_springboot_campus.controller;

import org.montanez.filtro_springboot_campus.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("api/oficina"))
public class inmuebleController {

    @Autowired
    private InmuebleService inmuebleService;

    

}

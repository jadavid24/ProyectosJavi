package com.javi.tienda.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("v1.0/tienda")
public class TiendaController {

    @GetMapping
    public ResponseEntity<String> getTiendas(){

        return ResponseEntity.ok("Funciona");
    }
}

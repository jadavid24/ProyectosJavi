package com.example.test.controller;

import com.example.test.model.Tienda;
import com.example.test.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/tiendas")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @GetMapping()
    public ResponseEntity<List<Tienda>> getTiendas(String ciudad) {
        List<Tienda> tiendas = tiendaService.getTiendas(ciudad);
        return ResponseEntity.ok(tiendas);

    }

    @GetMapping("/{idTienda}")
    public ResponseEntity<Tienda> getTiendaId(@PathVariable Integer idTienda) {

        Tienda tienda = tiendaService.getTiendaId(idTienda);
        return ResponseEntity.ok(tienda);
    }

    @PostMapping()
    public ResponseEntity<Tienda> createTienda(@RequestBody Tienda nuevaTienda) {
        Tienda tienda = tiendaService.createTienda(nuevaTienda);
        return ResponseEntity.ok(tienda);
    }

    @DeleteMapping("/{idTienda}")
    public ResponseEntity<Tienda> deleteTienda(@PathVariable Integer idTienda) {
        Tienda tienda = tiendaService.deleteTienda(idTienda);
        return ResponseEntity.ok(tienda);
    }
}





package com.example.test.controller;

import com.example.test.controller.model.TiendaDto;
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
    public ResponseEntity<List<TiendaDto>> getTiendas(String ciudad) {

        List<TiendaDto> tiendas = tiendaService.getTiendas(ciudad);
        return ResponseEntity.ok(tiendas);
    }

    @GetMapping("/{idTienda}")
    public ResponseEntity<TiendaDto> getTiendaId(@PathVariable Integer idTienda) {
        TiendaDto tienda = tiendaService.getTiendaId(idTienda);
        return ResponseEntity.ok(tienda);
    }

    @PutMapping("/{idTienda}")
    public ResponseEntity<TiendaDto> updateTienda(@RequestBody TiendaDto cambioTienda, @PathVariable Integer idTienda){
        TiendaDto tienda = tiendaService.updateTienda(cambioTienda,idTienda);
        return ResponseEntity.ok(tienda);
    }

    @PostMapping()
    public ResponseEntity<TiendaDto> createTienda(@RequestBody TiendaDto nuevaTienda) {
        TiendaDto tienda = tiendaService.createTienda(nuevaTienda);
        return ResponseEntity.ok(tienda);
    }

    @DeleteMapping("/{idTienda}")
    public ResponseEntity<TiendaDto> deleteTienda(@PathVariable Integer idTienda) {
        TiendaDto tienda = tiendaService.deleteTienda(idTienda);
        return ResponseEntity.ok(tienda);
    }
}


//CRUD: CREATE, READ, UPDATE, DELETE


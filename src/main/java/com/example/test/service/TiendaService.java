package com.example.test.service;

import com.example.test.controller.model.TiendaDto;
import com.example.test.model.Tienda;

import java.util.List;

public interface TiendaService {

    List<Tienda> getTiendas(String ciudad);

    TiendaDto getTiendaId (Integer idTienda);

    TiendaDto createTienda (TiendaDto tienda);

    Tienda deleteTienda (Integer idTienda);
}




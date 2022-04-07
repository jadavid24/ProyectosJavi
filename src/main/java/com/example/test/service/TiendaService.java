package com.example.test.service;

import com.example.test.controller.model.TiendaDto;

import java.util.List;

public interface TiendaService {

    List<TiendaDto> getTiendas(String ciudad);

    TiendaDto getTiendaId (Integer idTienda);

    TiendaDto updateTienda (TiendaDto cambioTienda,Integer idTienda);

    TiendaDto createTienda (TiendaDto tienda);

    TiendaDto deleteTienda (Integer idTienda);


}




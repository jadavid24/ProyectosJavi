package com.example.test.service;

import com.example.test.model.Tienda;

import java.util.List;

public interface TiendaService {

    List<Tienda> getTiendas(String ciudad);

    Tienda getTiendaId (Integer idTienda);

    Tienda createTienda (Tienda tienda);

    Tienda deleteTienda (Integer idTienda);
}




package com.example.test.service.impl;

import com.example.test.model.Tienda;
import com.example.test.repository.TiendaRepository;
import com.example.test.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiendaServiceImpl implements TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Override
    public List<Tienda> getTiendas(String ciudad) {

        if(ciudad != null){
            return tiendaRepository.getTiendasByCiudad(ciudad);
        }
        return tiendaRepository.findAll();
    }

    @Override
    public Tienda getTiendaId(Integer idTienda) {
        return tiendaRepository.findById(idTienda).orElse(null);
    }

    @Override
    public Tienda createTienda(Tienda tienda) {
        return tiendaRepository.saveAndFlush(tienda);
    }

    @Override
    public Tienda deleteTienda(Integer idTienda) {

        if (idTienda != null) {
            tiendaRepository.deleteById(idTienda);
        }
        return null;
    }
}
//tiendaRepository.findById()
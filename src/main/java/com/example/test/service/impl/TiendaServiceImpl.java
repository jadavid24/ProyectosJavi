package com.example.test.service.impl;

import com.example.test.controller.model.TiendaDto;
import com.example.test.model.Tienda;
import com.example.test.repository.TiendaRepository;
import com.example.test.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public TiendaDto getTiendaId(Integer idTienda) {

        Tienda t = tiendaRepository.findById(idTienda).orElse(null);
        TiendaDto tiendaDto = null;
        if(t != null) {
            tiendaDto = new TiendaDto(t.getIdTienda(),t.getNombreTienda(),t.getCiudad(),t.getDireccion());
        }
        return tiendaDto;
    }

    @Override
    public TiendaDto createTienda(TiendaDto tienda) {

        Tienda nuevaTienda = new Tienda(tienda.getNombreTienda(),tienda.getCiudad(),tienda.getDireccion());
        Tienda a = tiendaRepository.saveAndFlush(nuevaTienda);
        TiendaDto m = new TiendaDto(a.getIdTienda(),a.getNombreTienda(),a.getCiudad(),a.getDireccion());
        return m;
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
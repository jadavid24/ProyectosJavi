package com.example.test.service.impl;

import com.example.test.controller.model.TiendaDto;
import com.example.test.model.Tienda;
import com.example.test.repository.TiendaRepository;
import com.example.test.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TiendaServiceImpl implements TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    @Override
    public List<TiendaDto> getTiendas(String ciudad) {

        List<Tienda> tiendas;
        if(ciudad != null){
            tiendas = tiendaRepository.getTiendasByCiudad(ciudad);
        }else{
            tiendas = tiendaRepository.findAll();
        }

        List<TiendaDto> tiendasDto = new ArrayList<>();
        for (Tienda tienda:tiendas) {

            TiendaDto tiendaDto = new TiendaDto(tienda.getIdTienda(),tienda.getNombreTienda(),tienda.getCiudad(),tienda.getDireccion());
            tiendasDto.add(tiendaDto);
        }
        return tiendasDto;
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
    public TiendaDto updateTienda (TiendaDto cambioTienda,Integer idTienda){

        Tienda tienda = tiendaRepository.findById(idTienda).orElse(null);
        if (tienda != null){

            tienda.setNombreTienda(cambioTienda.getNombreTienda());
            tienda.setCiudad(cambioTienda.getCiudad());
            tienda.setDireccion(cambioTienda.getDireccion());
            Tienda actualizada = tiendaRepository.save(tienda);
            return new TiendaDto(actualizada.getIdTienda(),actualizada.getNombreTienda(),actualizada.getCiudad(),actualizada.getDireccion());
        }

        else {
            return null;
        }

    }

    @Override
    public TiendaDto createTienda(TiendaDto tienda) {

        Tienda nuevaTienda = new Tienda(tienda.getNombreTienda(),tienda.getCiudad(),tienda.getDireccion());
        Tienda a = tiendaRepository.saveAndFlush(nuevaTienda);
        return new TiendaDto(a.getIdTienda(),a.getNombreTienda(),a.getCiudad(),a.getDireccion());
    }

    @Override
    public TiendaDto deleteTienda(Integer idTienda) {

        TiendaDto tienda = getTiendaId(idTienda);
        if (tienda != null) {
            tiendaRepository.deleteById(idTienda);
        }
        return tienda;
    }
}
package com.example.test;

import com.example.test.controller.model.TiendaDto;
import com.example.test.model.Tienda;
import com.example.test.repository.TiendaRepository;
import com.example.test.service.impl.TiendaServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TiendaServiceImplTest {

    @InjectMocks
    private TiendaServiceImpl tiendaService;

    @Mock
    private TiendaRepository tiendaRepository;

    @Test
    public void getTiendaIdCorrecto(){

        when(tiendaRepository.findById(any(Integer.class))).thenReturn(Optional.of(new Tienda(1, "Nombre Test", "Ciudad Test", "Direccion Test")));
        final TiendaDto response = tiendaService.getTiendaId(2);
        final TiendaDto expected = new TiendaDto(1, "Nombre Test", "Ciudad Test", "Direccion Test");
        Assert.assertEquals(expected.getIdTienda(), response.getIdTienda());
        Assert.assertEquals(expected.getNombreTienda(), response.getNombreTienda());
        Assert.assertEquals(expected.getCiudad(), response.getCiudad());
        Assert.assertEquals(expected.getDireccion(), response.getDireccion());
    }

    @Test
    public void getTiendaIdIncorrecto(){

        when(tiendaRepository.findById(any(Integer.class))).thenReturn(Optional.empty());
        final TiendaDto response = tiendaService.getTiendaId(2);
        Assert.assertNull(response);
    }
}

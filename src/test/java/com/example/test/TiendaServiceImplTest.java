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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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


    @Test
    public void geTiendasConCiudad (){

        final List<Tienda> repositoryResponse = new ArrayList<>();
        final Tienda tiendaPrueba = new Tienda(5,"NombreTestJAvi","Bogota","DireccionJavi");
        repositoryResponse.add(tiendaPrueba);
        when(tiendaRepository.getTiendasByCiudad(any(String.class))).thenReturn(repositoryResponse);
        final List<TiendaDto> response = tiendaService.getTiendas("Bogota");
        final TiendaDto tiendaPruebaDto = new TiendaDto(5,"NombreTestJAvi","Bogota","DireccionJavi");
        final List<TiendaDto> expected = new ArrayList<>();
        expected.add(tiendaPruebaDto);
        Assert.assertEquals(response.size(),expected.size());
        Assert.assertEquals(response.get(0).getIdTienda(),expected.get(0).getIdTienda());
        Assert.assertEquals(response.get(0).getNombreTienda(),expected.get(0).getNombreTienda());
        Assert.assertEquals(response.get(0).getCiudad(),expected.get(0).getCiudad());
        Assert.assertEquals(response.get(0).getDireccion(),expected.get(0).getDireccion());

    }

    @Test

    public void getTiendasSinCiudad(){
        when(tiendaRepository.findAll()).thenReturn(new ArrayList<>());
        final List<TiendaDto> response = tiendaService.getTiendas(null);
        Assert.assertEquals(0,response.size());
    }

    @Test
    public void createTienda(){

        final TiendaDto tiendaPruebaDto = new TiendaDto(5,"NombreTestJAvi","Bogota","DireccionJavi");
        final Tienda tiendaPrueba = new Tienda(5,"NombreTestJAvi","Bogota","DireccionJavi");
        when(tiendaRepository.saveAndFlush(any(Tienda.class))).thenReturn(tiendaPrueba);
        final TiendaDto response = tiendaService.createTienda(tiendaPruebaDto);

        final TiendaDto expected = new TiendaDto(5,"NombreTestJAvi","Bogota","DireccionJavi");

        Assert.assertEquals(response.getIdTienda(), expected.getIdTienda());
        Assert.assertEquals(response.getNombreTienda(), expected.getNombreTienda());
        Assert.assertEquals(response.getCiudad(), expected.getCiudad());
        Assert.assertEquals(response.getDireccion(), expected.getDireccion());

        verify(tiendaRepository,times(1)).saveAndFlush(any(Tienda.class));
    }

    @Test
    public void deleteTiendaIdCorrecto() {

        when(tiendaRepository.findById(any(Integer.class))).thenReturn(Optional.of(new Tienda(2, "Nombre Delete", "Ciudad Delete", "Direccion Delete")));
        final TiendaDto response = tiendaService.deleteTienda(2);
        final TiendaDto expected = new TiendaDto(2, "Nombre Delete", "Ciudad Delete", "Direccion Delete");

        Assert.assertEquals(response.getIdTienda(),expected.getIdTienda());
        Assert.assertEquals(response.getNombreTienda(),expected.getNombreTienda());
        Assert.assertEquals(response.getCiudad(),expected.getCiudad());
        Assert.assertEquals(response.getDireccion(),expected.getDireccion());
        verify(tiendaRepository,times(1)).deleteById(any(Integer.class));

    }

    @Test
    public void deleteTiendaIdNull () {
        when(tiendaRepository.findById(any(Integer.class))).thenReturn(Optional.empty());
        final TiendaDto response = tiendaService.deleteTienda(2);
        Assert.assertNull(response);
    }


}




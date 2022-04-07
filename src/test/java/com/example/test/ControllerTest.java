package com.example.test;

import com.example.test.controller.TiendaController;
import com.example.test.controller.model.TiendaDto;
import com.example.test.service.TiendaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class ControllerTest {

    @InjectMocks
    private TiendaController tiendaController;

    @Mock
    private TiendaService tiendaService;

    @Test
    public void getTiendas () {

        final List<TiendaDto> tiendasPrueba = new ArrayList<>();
        final TiendaDto tiendaPruebaDto = new TiendaDto(5,"NombreTestJAvi","Bogota","DireccionJavi");
        tiendasPrueba.add(tiendaPruebaDto);
        when (tiendaService.getTiendas(anyString())).thenReturn(tiendasPrueba);

        var a =tiendaController.getTiendas("Bogota").getBody();
        var b = 0;

    }
}

package com.example.test;

import com.example.test.controller.model.TiendaDto;
import com.example.test.service.impl.TiendaServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;

public class TiendaServiceImplTest {

    @InjectMocks
    private TiendaServiceImpl tiendaService;

    @Test
    public void getTiendaIdCorrecto(){
        TiendaDto a = tiendaService.getTiendaId(2);
        var n = 0;
    }
}

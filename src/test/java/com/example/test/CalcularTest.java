package com.example.test;

import com.example.test.ejemplopruebas.Operaciones;
import org.junit.Assert;
import org.junit.Test;


public class CalcularTest {

    @Test
    public void sumatest(){
        Operaciones operacionestest = new Operaciones();
        double respuesta = operacionestest.calcular(4,3,Operaciones.SUMA);
        Assert.assertEquals(7,respuesta,0);
    }

    @Test
    public void restatest (){
        Operaciones operacionestest = new Operaciones();
        double respuesta = operacionestest.calcular(4,3,Operaciones.RESTAR);
        Assert.assertEquals(1,respuesta,0);
    }

    @Test
    public void multiplicartest (){
        Operaciones operacionestest = new Operaciones();
        double respuesta = operacionestest.calcular(4,3,Operaciones.MULTIPLICAR);
        Assert.assertEquals(12,respuesta,0);
    }

    @Test
    public void dividirtest (){
        Operaciones operacionestest = new Operaciones();
        double respuesta = operacionestest.calcular(4,3,Operaciones.DIVIDIR);
        Assert.assertEquals(1,respuesta,0);
    }

    @Test
    public void nulltest (){
        Operaciones operacionestest = new Operaciones();
        double respuesta = operacionestest.calcular(4,3,null);
        Assert.assertEquals(0,respuesta,0);
    }

    @Test
    public void differenttest (){
        Operaciones operacionestest = new Operaciones();
        double respuesta = operacionestest.calcular(4,3,"INTEGRAR");
        Assert.assertEquals(0,respuesta,0);
    }
}

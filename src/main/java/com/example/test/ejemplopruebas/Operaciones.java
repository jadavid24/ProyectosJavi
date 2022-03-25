package com.example.test.ejemplopruebas;

public class Operaciones {

    public static final String SUMA = "SUMAR";
    public static final String RESTAR = "RESTAR";
    public static final String MULTIPLICAR = "MULTIPLICAR";
    public static final String DIVIDIR = "DIVIDIR";

    public double calcular(final Integer n1,final Integer n2,final String operacion){
        if(operacion == null){
            return 0;
        }
        switch (operacion){
            case SUMA:
                return n1 + n2;
            case RESTAR:
                return n1 - n2;
            case MULTIPLICAR:
                return n1 * n2;
            case DIVIDIR:
                return n1 / n2;
            default:
                return 0;
        }
    }
}

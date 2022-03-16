package com.example.test.model;

import lombok.Getter;

@Getter
public enum Ciudades {
    BOGOTA ("Bogota"),
    CARTAGENA("Cartagena");

    private final String nombre ;

    Ciudades (String nombre){
        this.nombre = nombre;
    }
}

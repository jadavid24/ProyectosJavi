package com.example.test.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class MenuDto {

    private Integer idMenu;
    @NotNull
    private String nombreMenu;
    @NotNull
    private Double precio;
    @NotNull
    private Double estatus;

    public MenuDto (Integer idMenu, String nombreMenu,Double precio, Double estatus){
        this.idMenu = idMenu;
        this.nombreMenu = nombreMenu;
        this.precio = precio;
        this.estatus = estatus;
    }

}

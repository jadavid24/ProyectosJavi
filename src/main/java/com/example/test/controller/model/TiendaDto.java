package com.example.test.controller.model;

import javax.validation.constraints.NotNull;

public class TiendaDto {
    private Integer idTienda;
    @NotNull(message = "Debes especificar la existencia")
    private String nombreTienda;
    @NotNull
    private String ciudad;
    @NotNull
    private String direccion;

    public TiendaDto(Integer idTienda, String nombreTienda, String ciudad, String direccion) {
        this.idTienda = idTienda;
        this.nombreTienda = nombreTienda;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Integer getIdTienda() {
        return idTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

}



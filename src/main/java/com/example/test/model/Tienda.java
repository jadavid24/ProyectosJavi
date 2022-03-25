package com.example.test.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Table(name = "tienda",  schema = "vex")
public class Tienda{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_tienda")
    private Integer idTienda;

    @Column(name = "nombre_tienda")
    private String nombreTienda;

    @Column(name = "ciudad")
    private String ciudad;

    @Column(name = "direccion")
    private String direccion;

    public Tienda (String nombreTienda,String ciudad,String direccion){
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


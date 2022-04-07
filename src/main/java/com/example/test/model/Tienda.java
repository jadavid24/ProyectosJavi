package com.example.test.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
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

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_propietario")
    private Propietario propietario;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tienda")
    private List<Empleados> empleados;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tienda")
    private List<Menu> menus;

    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "tienda")
    private List<Productos> productos;


    public Tienda (String nombreTienda,String ciudad,String direccion){
        this.nombreTienda = nombreTienda;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Tienda (Integer idTienda, String nombreTienda,String ciudad,String direccion){
        this.idTienda =  idTienda;
        this.nombreTienda = nombreTienda;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }


}


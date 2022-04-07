package com.example.test.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "menu",  schema = "vex")

public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_menu")
    private Integer idMenu;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_tienda")
    private Tienda tienda;

    @Column(name = "nombre_menu")
    private String nombreMenu;

    @Column(name = "precio")
    private Double precio;

    @Column(name = "estatus")
    private Double estatus;
}



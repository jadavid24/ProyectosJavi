package com.example.test.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
@Table(name = "productos",  schema = "vex")

public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_producto")
    private Integer idProducto;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_tienda")
    private Tienda tienda;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_compra")
    private Date fechaCompra;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

}

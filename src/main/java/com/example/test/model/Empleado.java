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
@Table(name = "empleados",  schema = "vex")

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "salario")
    private Double salario;

    @JsonBackReference
    @ManyToOne()
    @JoinColumn(name = "id_tienda")
    private Tienda tienda;

    public Empleado (String nombre, String cargo,Double salario){
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    public Empleado(String nombreEmpleado, String cargo, Double salario, Tienda tienda) {
        this.nombre = nombreEmpleado;
        this.cargo = cargo;
        this.salario = salario;
        this.tienda = tienda;
    }

    public Empleado(String cargo) {
        this.cargo = cargo;
    }

}

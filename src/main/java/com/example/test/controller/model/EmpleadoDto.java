package com.example.test.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

public class EmpleadoDto {

    private Integer idEmpleado;
    @NotNull
    private String nombreEmpleado;
    @NotNull
    private String cargo;
    @NotNull
    private Double salario;

    public EmpleadoDto(Integer idEmpleado, String nombreEmpleado, String cargo, Double salario) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.cargo = cargo;
        this.salario = salario;
    }
}

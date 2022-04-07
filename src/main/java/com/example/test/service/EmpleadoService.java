package com.example.test.service;

import com.example.test.controller.model.EmpleadoDto;

import java.util.List;

public interface EmpleadoService {

    List<EmpleadoDto> getEmpleados(Integer idTienda);

    EmpleadoDto getEmpleadoId (Integer idEmpleado);

    EmpleadoDto updateEmpleados (EmpleadoDto cambioEmpleado, Integer idEmpleado);

    EmpleadoDto createEmpleado (EmpleadoDto empleado);

    EmpleadoDto deleteEmpleado (Integer idEmpleado);
}

package com.example.test.service.impl;

import com.example.test.controller.model.EmpleadoDto;
import com.example.test.model.Empleados;
import com.example.test.repository.EmpleadoRepository;
import com.example.test.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadosServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<EmpleadoDto> getEmpleados(Integer idTienda) {

        List<Empleados> empleados;
        if(idTienda != null){
            empleados = empleadoRepository.getEmpleadosByTienda_IdTienda(idTienda);
        }else{
            empleados = empleadoRepository.findAll();
        }

        List<EmpleadoDto> empleadosDto = new ArrayList<>();
        for (Empleados empleado:empleados) {

            EmpleadoDto empleadoDto = new EmpleadoDto(empleado.getIdEmpleado(),empleado.getNombre(),empleado.getCargo(),empleado.getSalario());
            empleadosDto.add(empleadoDto);
        }
        return empleadosDto;
    }

    @Override
    public EmpleadoDto getEmpleadoId(Integer idEmpleado) {
        return null;
    }

    @Override
    public EmpleadoDto updateEmpleados(EmpleadoDto cambioEmpleado, Integer idEmpleado) {
        return null;
    }

    @Override
    public EmpleadoDto createEmpleado(EmpleadoDto empleado) {
        return null;
    }

    @Override
    public EmpleadoDto deleteEmpleado(Integer idEmpleado) {
        return null;
    }
}

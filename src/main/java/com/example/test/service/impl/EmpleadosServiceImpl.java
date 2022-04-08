package com.example.test.service.impl;

import com.example.test.controller.model.EmpleadoDto;
import com.example.test.model.Empleado;
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
    public List<EmpleadoDto> getEmpleados(final Integer idTienda) {

        if(idTienda != null){
            List<Empleado> empleados;
            empleados = empleadoRepository.getEmpleadosByTienda_IdTienda(idTienda);
            List<EmpleadoDto> empleadosDto = new ArrayList<>();

            for (Empleado empleado:empleados) {
                EmpleadoDto empleadoDto = new EmpleadoDto(empleado.getIdEmpleado(),empleado.getNombre(),empleado.getCargo(),empleado.getSalario());
                empleadosDto.add(empleadoDto);
            }
            return empleadosDto;
        }

        else
        {
            return null;
        }
    }

    @Override
    public EmpleadoDto getEmpleadoId(Integer idTienda, Integer idEmpleado) {

           Empleado empleado = empleadoRepository.getEmpleadosByTienda_IdTiendaAndIdEmpleado(idTienda,idEmpleado);
           if (empleado != null) {
               return new EmpleadoDto(empleado.getIdEmpleado(), empleado.getNombre(), empleado.getCargo(), empleado.getSalario());
           }
           return null;
       }


    @Override
    public EmpleadoDto updateEmpleados(EmpleadoDto cambioEmpleado, Integer idEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado).orElse(null);
        if (empleado != null){
            empleado.setNombre(cambioEmpleado.getNombreEmpleado());
            empleado.setCargo(cambioEmpleado.getCargo());
            empleado.setSalario(cambioEmpleado.getSalario());
            Empleado actualizado = empleadoRepository.save(empleado);
            return new EmpleadoDto(actualizado.getIdEmpleado(),actualizado.getNombre(),actualizado.getCargo(),actualizado.getSalario());
        }
        return null;
    }

    @Override
    public EmpleadoDto createEmpleado(Integer idTienda,EmpleadoDto nuevoEmpleado) {

        Empleado nuevo = new Empleado(nuevoEmpleado.getNombreEmpleado(),nuevoEmpleado.getCargo(),nuevoEmpleado.getSalario());
        Integer idEmp = empleadoRepository.saveEmpleadoWithTienda( nuevo.getNombre(), nuevo.getCargo(), nuevo.getSalario(), idTienda);
        return new EmpleadoDto(idEmp,nuevoEmpleado.getNombreEmpleado(),nuevoEmpleado.getCargo(),nuevoEmpleado.getSalario());
    }

    @Override
    public EmpleadoDto deleteEmpleado(Integer idEmpleado) {
        return null;
    }
}

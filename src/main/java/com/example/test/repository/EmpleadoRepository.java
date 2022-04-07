package com.example.test.repository;

import com.example.test.model.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleados,Integer> {
    List<Empleados> getEmpleadosByTienda_IdTienda(Integer idTienda);
}

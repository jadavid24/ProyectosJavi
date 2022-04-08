package com.example.test.repository;

import com.example.test.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {

    List<Empleado> getEmpleadosByTienda_IdTienda(Integer idTienda);

    Empleado getEmpleadosByTienda_IdTiendaAndIdEmpleado(Integer idTienda, Integer idEmpleado);

    @Transactional
    @Query(value = "insert into vex.empleados (nombre, cargo, salario, id_tienda) values ((:nombre),:cargo,(:salario),(:idTienda)) returning id_empleado" , nativeQuery = true)
    Integer saveEmpleadoWithTienda(@Param("nombre") String nombre, @Param("cargo") String cargo, @Param("salario") Double salario, @Param("idTienda")  Integer idTienda);
}



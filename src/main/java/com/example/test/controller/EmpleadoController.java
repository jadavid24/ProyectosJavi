package com.example.test.controller;

import com.example.test.controller.model.EmpleadoDto;
import com.example.test.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1.0/")

public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("tiendas/{idTienda}/empleados")
    public ResponseEntity<List<EmpleadoDto>> getEmpleados(@PathVariable Integer idTienda) {

        List<EmpleadoDto> empleados = empleadoService.getEmpleados(idTienda);
        return ResponseEntity.ok(empleados);
    }

    @GetMapping("tiendas/{idTienda}/empleados/{idEmpleado}")
    public ResponseEntity<EmpleadoDto> getEmpleadoId (@PathVariable Integer idTienda, @PathVariable Integer idEmpleado) {
        EmpleadoDto empleado = empleadoService.getEmpleadoId(idTienda, idEmpleado);
        return ResponseEntity.ok(empleado);
    }

    @PutMapping("tiendas/idTienda/empleados/{idEmpleado}")
    public ResponseEntity<EmpleadoDto> updateEmpleado (@RequestBody EmpleadoDto cambioEmpleado, @PathVariable Integer idEmpleado){
        EmpleadoDto empleado = empleadoService.updateEmpleados(cambioEmpleado,idEmpleado);
        return ResponseEntity.ok(empleado);
    }

    @PostMapping("tiendas/{idTienda}/empleados")
    public ResponseEntity<EmpleadoDto> createTienda(@PathVariable Integer idTienda,@RequestBody EmpleadoDto nuevoEmpleado) {
        EmpleadoDto empleado = empleadoService.createEmpleado(idTienda,nuevoEmpleado);
        return ResponseEntity.ok(empleado);
    }

    @DeleteMapping("tiendas/{idTienda}/empleados/{idEmpleado}")
    public ResponseEntity<EmpleadoDto> deleteTienda(@PathVariable Integer idEmpleado) {
        EmpleadoDto empleado = empleadoService.deleteEmpleado(idEmpleado);
        return ResponseEntity.ok(empleado);
    }
}

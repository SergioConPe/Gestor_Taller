package com.taller.gestion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taller.gestion.Model.Empleado;
import com.taller.gestion.Service.EmpleadoService;

import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    // Crear un nuevo empleado
    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoService.saveEmpleado(empleado);
        return new ResponseEntity<>(nuevoEmpleado, HttpStatus.CREATED);
    }

    // Obtener todos los empleados
    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.findAllEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    // Obtener un empleado por nombre
    @GetMapping("/{nombreMecanico}")
    public ResponseEntity<Empleado> getEmpleadoByNombre(@PathVariable String nombreMecanico) {
        Empleado empleado = empleadoService.findByNombreMecanico(nombreMecanico);
        if (empleado != null) {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar un empleado
    @PutMapping("/{nombreMecanico}")
    public ResponseEntity<Empleado> updateEmpleadoController(@PathVariable String nombreMecanico, @RequestBody Empleado empleadoActualizado) {
        Empleado empleado = empleadoService.updateEmpleado(nombreMecanico, empleadoActualizado);
        if (empleado != null) {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un empleado
    @DeleteMapping("/{nombreMecanico}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable String nombreMecanico) {
        empleadoService.deleteByNombre(nombreMecanico);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

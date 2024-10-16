package com.taller.gestion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taller.gestion.Model.Reparacion;
import com.taller.gestion.Service.ReparacionService;

import java.util.List;

@RestController
@RequestMapping("/reparaciones")
public class ReparacionController {

    @Autowired
    private ReparacionService reparacionService;

//Crear una nueva reparación
    @PostMapping
    public ResponseEntity<Reparacion> createReparacion(@RequestBody Reparacion reparacion) {
        Reparacion nuevaReparacion = reparacionService.saveReparacion(reparacion);
        return new ResponseEntity<>(nuevaReparacion, HttpStatus.CREATED);
    }

//Obtener todas las reparaciones
    @GetMapping
    public ResponseEntity<List<Reparacion>> getAllReparaciones() {
        List<Reparacion> reparaciones = reparacionService.findAllReparaciones();
        return new ResponseEntity<>(reparaciones, HttpStatus.OK);
    }

//Obtener una reparación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Reparacion> getReparacionById(@PathVariable Long id) {
        Reparacion reparacion = reparacionService.findReparacionById(id);
        if (reparacion != null) {
            return new ResponseEntity<>(reparacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//Actualizar una reparación
    @PutMapping("/{id}")
    public ResponseEntity<Reparacion> updateReparacion(@PathVariable Long id, @RequestBody Reparacion reparacionActualizada) {
        Reparacion reparacion = reparacionService.updateReparacion(id, reparacionActualizada);
        if (reparacion != null) {
            return new ResponseEntity<>(reparacion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

//Eliminar una reparación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReparacion(@PathVariable Long id) {
        reparacionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}



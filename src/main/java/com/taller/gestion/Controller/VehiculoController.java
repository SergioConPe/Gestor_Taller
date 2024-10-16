package com.taller.gestion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taller.gestion.Model.Vehiculo;
import com.taller.gestion.Service.VehiculoService;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {

	@Autowired
	private VehiculoService vehiculoService;
	
//Crear un vehiculo nuevo
	@PostMapping
	public ResponseEntity<List<Vehiculo>> getAllVehiculos(){
		List<Vehiculo> vehiculos = vehiculoService.findAll();
		return new ResponseEntity<>(vehiculos, HttpStatus.OK);
	}	
//Obtener un vehiculo por su matrícula
	@GetMapping
	public ResponseEntity<Vehiculo> getVehiculoByMatricula(@PathVariable String matricula){
		Vehiculo vehiculo = vehiculoService.findByMatricula(matricula);
		if (vehiculo != null) {
			return new ResponseEntity<>(vehiculo, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
//Actualizar un vehiculo
	@PutMapping("/{matricula}")
	public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable String matricula, 
			@RequestBody Vehiculo vehiculoActualizado) {
		Vehiculo vehiculo = vehiculoService.update(matricula, vehiculoActualizado);
        if (vehiculo != null) {
            return new ResponseEntity<>(vehiculo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
//Eliminar un vehículo
    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable String matricula) {
        vehiculoService.deleteByMatricula(matricula);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package com.taller.gestion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.gestion.Model.Empleado;
import com.taller.gestion.Repository.EmpleadoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;
	
//Guardar o actualizar 
	public Empleado saveEmpleado(Empleado empleado) {
		return empleadoRepository.save(empleado);
	}
//Obtener una lista de todos los empleados
	public List<Empleado> findAllEmpleados(){
		return empleadoRepository.findAll();
	}
	
//Buscar un empleado por su nombreMecanico
    public Empleado findByNombreMecanico(String nombreMecanico) {
        return empleadoRepository.findById(nombreMecanico).orElse(null);
    }
    
//Actualizar un empleado
	public Empleado updateEmpleado(String nombreMecanico, Empleado empleadoActualizado) {
		Optional<Empleado> optionalEmpleado = empleadoRepository.findById(nombreMecanico);
		if (optionalEmpleado.isPresent()) {
			Empleado empleado = optionalEmpleado.get();
			empleado.setNombreMecanico(empleadoActualizado.getNombreMecanico());
			empleado.setEspecialidad(empleadoActualizado.getEspecialidad());
			return empleadoRepository.save(empleado);
		}
		return null;
	}

//Eliminar un empleado por su Nombre
	public void deleteByNombre(String nombreMecanico) {
		empleadoRepository.deleteById(nombreMecanico);
		System.out.println("EL EMPLEADO: " + nombreMecanico + " HA SIDO ELIMINADO");
	}
	
}

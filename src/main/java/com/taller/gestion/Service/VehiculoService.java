package com.taller.gestion.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.gestion.Model.Vehiculo;
import com.taller.gestion.Repository.VehiculoRepository;

@Service
public class VehiculoService {
	
	@Autowired
	private VehiculoRepository vehiculoRepository;
	
//Para registrar un vehículo
	public Vehiculo saveVehiculo(Vehiculo vehiculo) {
		return vehiculoRepository.save(vehiculo);
	}
//Lista de vehiculos
	public List<Vehiculo> findAll(){
		return vehiculoRepository.findAll();
		
	}
//buscar Vehículo por su matricula
	public Vehiculo findByMatricula(String matricula) {
		Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(matricula);
		return null;
		
	}
//modificar un registro
	public Vehiculo update(String matricula, Vehiculo vehiculoActualizado) {
        Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(matricula);
        if (optionalVehiculo.isPresent()) {
            Vehiculo vehiculo = optionalVehiculo.get();
        	vehiculo.setTipo(vehiculoActualizado.getTipo());
            vehiculo.setMarca(vehiculoActualizado.getMarca());
            vehiculo.setModelo(vehiculoActualizado.getModelo());
            vehiculo.setAño(vehiculoActualizado.getAño());
            vehiculo.setMotor(vehiculoActualizado.getMotor());
//No permitimos que se modifique la matrícula ya que es el identificador
            return vehiculoRepository.save(vehiculo);
        }
        return null;
    }
//Eliminar un vehiculo de la BBDD
	public void deleteByMatricula(String matricula) {
		vehiculoRepository.deleteById(matricula);
		System.out.println("SE HA BORRADO EL REGISTRO DEL VEHICULO" + matricula);
	}
}

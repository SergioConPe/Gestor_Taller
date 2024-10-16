package com.taller.gestion.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.taller.gestion.Model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String>{
	Optional<Empleado> findById(String nombreMecanico);
}

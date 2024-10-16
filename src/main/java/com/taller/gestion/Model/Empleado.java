package com.taller.gestion.Model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Empleado {

	@Id
	private String nombreMecanico;
	private String especialidad;
	
	@OneToMany(mappedBy = "empleado")
	private List<Reparacion> reparaciones;
	
//Constructores y getters setters
	public Empleado() {}
	
	public Empleado(String nombreMecanico, String especialidad) {
		this.nombreMecanico = nombreMecanico;
		this.especialidad   = especialidad;	
	}

	public String getNombreMecanico() {
		return nombreMecanico;
	}

	public void setNombreMecanico(String nombreMecanico) {
		this.nombreMecanico = nombreMecanico;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public List<Reparacion> getReparaciones() {
		return reparaciones;
	}

	public void setReparaciones(List<Reparacion> reparaciones) {
		this.reparaciones = reparaciones;
	}

	@Override
	public String toString() {
		return "Empleado [nombreMecanico=" + nombreMecanico + ", especialidad=" + especialidad 
				+ ", reparaciones=" + reparaciones + "]";
	}
	
	
}

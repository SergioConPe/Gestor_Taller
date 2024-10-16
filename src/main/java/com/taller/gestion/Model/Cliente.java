package com.taller.gestion.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreCliente;
	private String telefono;
	
	@OneToMany(mappedBy = "cliente")
	private List<Vehiculo> vehiculos;//El cliente puede tener varios vehículos
	
//Constructores
	public Cliente() {}
	
	public Cliente(String nombreCliente, String telefono) {
		this.nombreCliente   = nombreCliente;
		this.telefono        = telefono; 
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombreCliente;
	}

	public void setNombre(String nombre) {
		this.nombreCliente = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombreCliente + ", telefono=" 
				+ telefono + ", vehiculos=" + vehiculos + "]";
	}
	
}

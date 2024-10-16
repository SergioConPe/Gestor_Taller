package com.taller.gestion.Model;

import javax.persistence.*;

@Entity  //Generamos la entidad que será una tabla en la BD
public class Vehiculo {
//Los atributos de clase serán las columnas
	@Id //La matrícula del coche actuará de identificador único
	@Column(name = "matricula", unique = true)
	private String matricula;
	
	private String tipo;
	private String marca;
	private String modelo;
	private int año;
	private String motor;
//Esto lo añadimos cuando relacionamos la Clase Vehiculo con la clase Cliente	
	@ManyToOne
    private Cliente cliente; // Un vehículo pertenece a un solo cliente
	
//Le añadimos el constructor vacío
	public Vehiculo() {}
//El contructor
	public Vehiculo(String matricula, String tipo, String marca, String modelo, int año, String motor) {
		this.matricula = matricula;
		this.tipo      = tipo;
	 	this.marca     = marca;
	 	this.modelo    = modelo;
	 	this.año       = año;
	 	this.motor     = motor;
	}
//Añadimos los getters y setters
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getMotor() {
		return motor;
	}
	public void setMotor(String motor) {
		this.motor = motor;
	}
	@Override
	public String toString() {
		return "Vehiculo [matricula=" + matricula + ", tipo=" + tipo + ", marca=" + marca 
				+ ", modelo=" + modelo + ", año=" + año + ", motor=" + motor + "]";
	}
	
	

	
}

package com.taller.gestion.Model;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.*;

@Entity
public class Reparacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;
	private int horasInvertidas;
	private String material;
	private double costeFinal;
	
	@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaEntrada;
	
	@ManyToOne
	@JoinColumn(name = "vehiculo_matricula", nullable = false) // Suponiendo que la matrícula actúa como clave foránea
    private Vehiculo vehiculo;  // Relacionado con el vehículo
	
	@ManyToOne
	@JoinColumn(name = "empleado_nombre_mecanico", nullable = false)//Actua como clave foranea
	private Empleado empleado; // Relacionado con el mecanico que hace la reparacion

    // Constructor, getters y setters
    public Reparacion() {}
    
    public Reparacion(Date fechaEntrada, String descripcion, int horasInvertidas, 
    					String material, double costeFinal, Vehiculo vehiculo) {
        this.fechaEntrada = fechaEntrada;
        this.descripcion = descripcion;
        this.horasInvertidas = horasInvertidas;
        this.material = material;
        this.costeFinal = costeFinal;
        this.vehiculo = vehiculo;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getHorasInvertidas() {
		return horasInvertidas;
	}

	public void setHorasInvertidas(int horasInvertidas) {
		this.horasInvertidas = horasInvertidas;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getCosteFinal() {
		return costeFinal;
	}

	public void setCosteFinal(double costeFinal) {
		this.costeFinal = costeFinal;
	}

	public Date getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(Date fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	
	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
	

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Reparacion [id=" + id + ", descripcion=" + descripcion + ", horasInvertidas=" 
				+ horasInvertidas + ", material=" + material + ", costeFinal=" + costeFinal 
				+ ", fechaEntrada=" + fechaEntrada + ", vehiculo=" + vehiculo + ", empleado="
				+ empleado + "]";
	}

	

    
}

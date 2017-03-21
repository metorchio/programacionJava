package ar.com.maxo.entities.impl;

import java.util.Date;

public class Persona {
	
	private String nombre;
		
	private Date fechaDeNacimiento;
	
	public Persona(String nombre, Date fechaDeNacimiento) {
		this.nombre = nombre;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
}

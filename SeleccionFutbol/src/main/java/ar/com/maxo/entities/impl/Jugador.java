package ar.com.maxo.entities.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Jugador extends Persona {

	private Equipo equipo;
	private List<Gol> goles;
	
	public Jugador(String nombre, Date fechaDeNacimiento) {
		super(nombre, fechaDeNacimiento);
		goles = new ArrayList<Gol>();
	}
	
	public Jugador(String nombre, Date fechaDeNacimiento, Equipo equipo) {
		this(nombre, fechaDeNacimiento);
		this.setEquipo(equipo);
	}

	public Gol haceUnGol(Integer minuto) {
		Gol gol = new Gol(minuto, this);
		goles.add(gol);
		return gol;
	}
	
	
	//-------------- Setter & Getter --------------
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Gol> getGoles() {
		return goles;
	}

	public void setGoles(List<Gol> goles) {
		this.goles = goles;
	}
}

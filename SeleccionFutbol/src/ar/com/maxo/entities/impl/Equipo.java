package ar.com.maxo.entities.impl;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
	
	private String nombre;
	private List<Jugador> jugadores;
	
	public Equipo(String nombre) {
		this.setNombre(nombre);
		this.jugadores = new ArrayList<>();
	}
	
	public Equipo(List<Jugador> jugadores, String nombre) {
		this.setNombre(nombre);
		this.jugadores = jugadores;
	}

	
	//-------------- Setter & Getter --------------
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

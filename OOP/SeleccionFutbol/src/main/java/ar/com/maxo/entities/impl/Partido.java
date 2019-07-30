package ar.com.maxo.entities.impl;

import java.util.ArrayList;
import java.util.List;

public class Partido {
	
	private List<Equipo> equipos;
	private List<Gol> goles;
	
	public Partido(){
		this.equipos = new ArrayList<>();
		this.goles = new ArrayList<>();
	}
	
	public Partido( List<Equipo> equipos ) {
		this.equipos = equipos;
		this.goles = new ArrayList<>();
	}

	
	public void seHaceUnGol(Integer minuto, Jugador jugador) {
		int existeEquipo = this.equipos.indexOf( jugador.getEquipo() );
		if( existeEquipo != -1 ) {
			Equipo equipo = this.equipos.get(existeEquipo);
			int existeJugador =  equipo.getJugadores().indexOf( jugador );
			if( existeJugador != -1 ) {
				jugador = equipo.getJugadores().get(existeJugador);
				Gol gol = jugador.haceUnGol(minuto);
				this.goles.add(gol);
				System.out.println("[INFO] se hizo un gol. Minuto: " + minuto + " Jugador: " + jugador.getNombre() );
			} else {
				System.out.println("[ERROR] el jugador '" + jugador.getNombre() + "' no existe en el equipo.");
			}
		} else {
			System.out.println("[ERROR] el equipo '" + jugador.getEquipo().getNombre() + "' no existe en el partido.");
		}
	}
	
	//-------------- Setter & Getter --------------
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	public List<Gol> getGoles() {
		return goles;
	}

	public void setGoles(List<Gol> goles) {
		this.goles = goles;
	}
}

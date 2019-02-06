package ar.com.maxo;

import java.util.Date;

import ar.com.maxo.entities.impl.Equipo;
import ar.com.maxo.entities.impl.Gol;
import ar.com.maxo.entities.impl.Jugador;
import ar.com.maxo.entities.impl.Partido;

public class MainApp {

	public static void main(String[] args) {
		Partido partido = crearPartido();
		
		jugarPartido(partido);
		
		//TODO: Probar ambos métodos, de a uno a la vez.
		//golMalComputado(partido);
		golMalComputado_v2(partido);
		
		comparoObjetos(partido);
	}

	private static Partido crearPartido() {
		Equipo equipo1 = new Equipo("Independiente");
		Equipo equipo2 = new Equipo("River");
		
		Jugador jugador1 = new Jugador("Maxi", new Date(), equipo1 );
		Jugador jugador2 = new Jugador("Juan", new Date(), equipo1);
		Jugador jugador3 = new Jugador("Carlo", new Date(), equipo1);
		Jugador jugador4 = new Jugador("Tucu", new Date(), equipo1);
		Jugador jugador5 = new Jugador("Pipi", new Date(), equipo1);

		Jugador jugador6 = new Jugador("Pepe", new Date(), equipo2);
		Jugador jugador7 = new Jugador("Nico", new Date(), equipo2);
		Jugador jugador8 = new Jugador("Alex", new Date(), equipo2);
		Jugador jugador9 = new Jugador("Javi", new Date(), equipo2);
		Jugador jugador10 = new Jugador("Otro", new Date(), equipo2);
		
		equipo1.getJugadores().add(jugador1);
		equipo1.getJugadores().add(jugador2);
		equipo1.getJugadores().add(jugador3);
		equipo1.getJugadores().add(jugador4);
		equipo1.getJugadores().add(jugador5);
		
		equipo2.getJugadores().add(jugador6);
		equipo2.getJugadores().add(jugador7);
		equipo2.getJugadores().add(jugador8);
		equipo2.getJugadores().add(jugador9);
		equipo2.getJugadores().add(jugador10);

		Partido partido = new Partido();
		partido.getEquipos().add(equipo1);
		partido.getEquipos().add(equipo2);
		
		return partido;
	}
	
	private static void jugarPartido(Partido partido) {
		System.out.println("-------------- jugarPartido -------------- ");
		Equipo equipo1 = partido.getEquipos().get(0);
		//Primer gol
		Jugador jugador3 = equipo1.getJugadores().get(3);
		partido.seHaceUnGol(11, jugador3);
		
		//Se crea un jugador NO perteneciente al partido, con el nombre de "suplente".
		Jugador jugadorSuplente = new Jugador("suplente", new Date(), equipo1 );
		partido.seHaceUnGol(13, jugadorSuplente);
		
		//Se crean un equipo y un jugador, NO pertenecientes al partido.
		Equipo equipo3 = new Equipo("Boca");
		Jugador jugador11 = new Jugador("Matias", new Date(), equipo3 );
		partido.seHaceUnGol(15, jugador11);
		
		//Segundo gol
		partido.seHaceUnGol(15, jugador3);
		//Tercer gol
		partido.seHaceUnGol(45, jugador3);
		
		System.out.println("\nResultados:");
		System.out.println("En el partido se hicieron: " + partido.getGoles().size() + " goles.");
		System.out.print("Los goleadores del partido fueron: ");
		for( Equipo equipo : partido.getEquipos() ){			
			for( Jugador jugador : equipo.getJugadores() ){
				if( jugador.getGoles().size() > 0 ) {				
					System.out.print( jugador.getNombre() + ", " );
				}
			}
		}
		System.out.println();
		for( Gol gol : partido.getGoles() ){
			System.out.println( gol.getJugador().getNombre() + " hizo un gol en el minuto " + gol.getMinuto() );
		}
	}
	
	private static void golMalComputado(Partido partido) {
		System.out.println("\n-------------- golMalComputado -------------- ");
		Equipo equipo2 = partido.getEquipos().get(1);
		
		//consigo el primer gol del partido.
		Gol golMalComputado = partido.getGoles().get(0); 

		//cambio quien fue el jugador del gol, por el jugador numero 2 del equipo 2.
		Jugador jugadorAlQueLeQuitoElGol = golMalComputado.getJugador();
		jugadorAlQueLeQuitoElGol.getGoles().remove(golMalComputado);
		
		Jugador jugadorAlQueLeAgregoElGol = equipo2.getJugadores().get(1);
		jugadorAlQueLeAgregoElGol.getGoles().add(golMalComputado);
		
		//le asigno el nuevo jugador al gol.
		//TODO Probar ¿qué pasa si comento esta línea?
		golMalComputado.setJugador( jugadorAlQueLeAgregoElGol );
		
		System.out.println("Resultados:");
		System.out.print("Los goleadores del partido fueron: ");
		for( Equipo equipo : partido.getEquipos() ){			
			for( Jugador jugador : equipo.getJugadores() ){
				if( jugador.getGoles().size() > 0 ) {				
					System.out.print( jugador.getNombre() + ", " );
				}
			}
		}
		System.out.println();
		for( Gol gol : partido.getGoles() ){
			System.out.println( gol.getJugador().getNombre() + " hizo un gol en el minuto " + gol.getMinuto() );
		}
	}
	
	private static void comparoObjetos(Object objeto) {
		System.out.println("\n-------------- comparoObjetos -------------- ");
		Partido partido = (Partido) objeto;
		Equipo equipo1 = partido.getEquipos().get(0);
		Jugador jugador3 = equipo1.getJugadores().get(3);
		
		if( partido.getGoles().get(0) == jugador3.getGoles().get(0) ) {
			System.out.println("Es el mismo objeto !!!");
			System.out.println( "partido.getGoles().get(0) : " + partido.getGoles().get(0) );
			System.out.println( "jugador3.getGoles().get(0) : " + jugador3.getGoles().get(0) );
		} else {
			System.out.println("Los objetos son diferentes !");
			System.out.println( "partido.getGoles().get(0) : " + partido.getGoles().get(0) );
			System.out.println( "jugador3.getGoles().get(0) : " + jugador3.getGoles().get(0) );
		}
		
	}
	
	private static void golMalComputado_v2(Partido partido){		
		System.out.println("\n-------------- golMalComputado V2 -------------- ");
		//copio el segundo gol del partido.
		Gol golMalComputado = partido.getGoles().get(0);
		Integer minutoDelGolMalComputado = golMalComputado.getMinuto();
		Jugador jugadorDelGolMalComputado = golMalComputado.getJugador();

		//borro el gol mal computado.
		partido.getGoles().remove(golMalComputado);
		jugadorDelGolMalComputado.getGoles().remove(golMalComputado);
		
		//le asigno un gol al jugador numero 2 del equipo 2.
		Jugador jugadorAlQueLeAgregoElGol = partido.getEquipos().get(1).getJugadores().get(1);
		partido.seHaceUnGol(minutoDelGolMalComputado, jugadorAlQueLeAgregoElGol);
		
		System.out.println("Resultados:");
		System.out.print("Los goleadores del partido fueron: ");
		for( Equipo equipo : partido.getEquipos() ){			
			for( Jugador jugador : equipo.getJugadores() ){
				if( jugador.getGoles().size() > 0 ) {				
					System.out.print( jugador.getNombre() + ", " );
				}
			}
		}
		System.out.println();
		for( Gol gol : partido.getGoles() ){
			System.out.println( gol.getJugador().getNombre() + " hizo un gol en el minuto " + gol.getMinuto() );
		}
	}
}

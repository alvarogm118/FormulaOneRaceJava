package es.upm.dit.prog.practica5;

import java.util.Arrays;
import java.util.Random;



public class PruebaGranPremio {
	public static void main (String[] args) {
		GranPremio gp = new GranPremio ("Barcelona");
		Corredor [] cs = {		
				new Corredor ("Nico Rosberg", "ROS", "GE", "Mercedes"),
				new Corredor ("Lewis Hamilton", "HAM", "UK","Mercedes"),
				new Corredor ("Daniel Ricciardo", "RIC", "AUS", "Red Bull"),
				new Corredor ("Sebastian Vettel", "VET", "GE", "Ferrari"),
				new Corredor ("Max Verstappen", "VER", "NE", "Red Bull"),
				new Corredor ("Kimi Raikkonen", "RAI", "FI", "Ferrari"),
				new Corredor ("Sergio Perez", "PER", "ME", "Force India"),
				new Corredor ("Valtteri Bottas", "BOT", "FI", "Williams"),
				new Corredor ("Nico Hulkenberg", "HUL", "GE", "Force India"),
				new Corredor ("Fernando Alonso", "ALO", "ES", "McLaren Honda"),
				new Corredor ("Felipe Massa", "MAS", "BR", "Williams"),
				new Corredor ("Carlos Sainz", "SAI", "ES", "Toro Rosso"),
				new Corredor ("Romain Grosjean", "GRO", "FR", "Haas F1 Team"),
				new Corredor ("Daniil Kvyat", "KVY", "RU", "Toro Rosso"),
				new Corredor ("Jenson Button", "BUT", "UK", "McLaren Honda")
		};
				
				
		int nPrueba = 0;
		
     	// ok addCorredor
		nPrueba++;
		boolean res = true;
		for (int i = 0; i < cs.length; i++) {
			if (!gp.addCorredor (cs[i]))
				res = false;
		}
		System.out.println("Prueba " + nPrueba + " : " + res + " ok add corredor 15 veces");
		System.out.println("GP: " + gp);
		
		// ok vuelta
		nPrueba++;
		for (int n = 0; n < 19; n++) {
			long tvuelta = 95000;
			Random r = new Random();
			for (int i = 0; i < cs.length; i++) {
				tvuelta += (long)(r.nextDouble()*100);
				gp.vuelta (cs[i], tvuelta); 
			}
		}
		System.out.println("Prueba " + nPrueba + " : ok 20 vueltas todos");
		System.out.println("GP: " + gp);
	
		// ok finCarrera
		nPrueba++;
		long tvuelta = 95000;
		Random r = new Random();
		for (int i = 0; i < cs.length; i++) {
			tvuelta += (long)(r.nextDouble()*100);
			gp.finCarrera (cs[i], tvuelta); 
		}
		System.out.println("Prueba " + nPrueba + " : ok finCarrera");
		System.out.println("GP: " + gp);

		// ok SelectorTrue
		nPrueba++;
		System.out.println("Prueba " + nPrueba + " : ok selectorTrue");
		System.out.println(gp.getCorredores(new SelectorTrue()).toString());
		
		// ok SelectorPais
		nPrueba++;
		System.out.println("Prueba " + nPrueba + " : ok selectorPais ES");
		System.out.println(gp.getCorredores(new SelectorPais("ES")).toString());

		// ok SelectorEscuderia
		nPrueba++;
		System.out.println("Prueba " + nPrueba + " : ok selectorEscuderia Red Bull");
		System.out.println(gp.getCorredores(new SelectorEscuderia("Red Bull")).toString());
		
		// ok SelectorPodio
		nPrueba++;
		System.out.println("Prueba " + nPrueba + " : ok selectorPodio");
		System.out.println(gp.getCorredores(new SelectorPodio()).toString());
		
		// ok Selector10Primeros
		nPrueba++;
		System.out.println("Prueba " + nPrueba + " : ok selector10Primeros");
		System.out.println(gp.getCorredores(new Selector10Primeros()).toString());

		// ok SelectorTiempoVuelta (95500)
		nPrueba++;
		System.out.println("Prueba " + nPrueba + " : ok selectorTiempoVuelta 95500");
		System.out.println(gp.getCorredores(new SelectorTiempoVuelta(95500)).toString());


		
	}
}

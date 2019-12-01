package es.upm.dit.prog.practica5;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import es.upm.dit.prog.practica5.Corredor;

public class GranPremio {
private String circuito;
private ArrayList<Corredor> corredores;
private ArrayList<Corredor> boxes;
private ArrayList<Corredor> fueraDeCarrera;

@Override
public String toString() {
	return "GranPremio [circuito=" + circuito + "]";
}

// Constructor
public GranPremio (String nombre){ 
	this.circuito = nombre;
	this.corredores = new ArrayList<Corredor>();
	this.boxes = new ArrayList<Corredor>();
	this.fueraDeCarrera = new ArrayList<Corredor>();
}
	
//Metodos

public boolean addCorredor(Corredor c) { //Metodo 2
		if (c != null) {
		corredores.add(c); 
		return true;
		}
	return false;

}

public boolean addCorredor(Corredor c, int n){ //Metodo 4
	if ((c != null) && (n >= 0) && (n < corredores.size())){
		corredores.add(n,c);
		return true;
	}
	return false;
}



public void inicioCarrera(){ //Metodo 9
	for (int i=0; i < corredores.size(); i++){
		if (corredores.get(i) != null){
			corredores.get(i).enCarrera();
		}
	}
}

public int getPosicion(ArrayList<Corredor> cs, Corredor c){ //Metodo 10
		for (int i=0; i < cs.size(); i++){
			if (cs.get(i) != null && cs.get(i).equals(c)){
				return i;
			}
		}
	return -1;	

}

public void vuelta(Corredor c, long t){ //Metodo 11
	int x = getPosicion(corredores,c);
	if (x != -1){
		corredores.get(x).vuelta(t);
	}
}

public void finCarrera(Corredor c, long t){ //Metodo 12
	int x = getPosicion(corredores,c);
	if (x != -1){
		corredores.get(x).finCarrera(t);
	}
}

private boolean removeCorredor(ArrayList<Corredor> cs, Corredor c){ //Metodo 14
	int n = getPosicion(cs,c);
	if (n != -1){
		cs.remove(n);
		return true;
		}
	return false;
}

public void fueraDeCarrera(Corredor c){ //Metodo 15
	int x = getPosicion(corredores,c);
	if (x != -1){
		removeCorredor(corredores,c);
		fueraDeCarrera.add(c);
		fueraDeCarrera.get(x).fueraCarrera();
	}
}

public void aBoxes(Corredor c){ //Metodo 16
	int x = getPosicion(corredores,c);
	if (x != -1){
		removeCorredor(corredores,c);
		boxes.add(c);
		boxes.get(x).fueraCarrera();
	}
}


public void deBoxes(Corredor c, int n){ //Metodo 17
	if (getPosicion(boxes,c) != -1 && n >= 0 && n < corredores.size()){
		removeCorredor(boxes,c);
		corredores.add(n, c);
		corredores.get(n).enCarrera();
	}
}

public boolean adelanta(Corredor c1, Corredor c2){ //Metodo 19
	int h = getPosicion(corredores, c1);
	int r = getPosicion(corredores, c2);
	if (h != -1 && r != -1 && c1 != null && c2 != null){
		Collections.swap(corredores, r, h);
		return true;

	}
	return false;
}
 // Metodo getCorredores practica4

public ArrayList<Corredor> getCorredores(Selector s){
	ArrayList<Corredor> Corredores = new ArrayList<Corredor>();
	if (s == null){
		s = new SelectorTrue();
		for (int i=0; i< corredores.size(); i++){
			if (s.selecciona(corredores.get(i)) == true && corredores.get(i) != null){
				Corredores.add(corredores.get(i));
			}

		}
	}
	else if (s instanceof SelectorTrue || s instanceof SelectorEscuderia || s instanceof SelectorPais || s instanceof SelectorTiempoVuelta){
		for (int i=0; i< corredores.size(); i++){
			if (s.selecciona(corredores.get(i)) == true && corredores.get(i) != null){
				Corredores.add(corredores.get(i));
			}

		}
	}
	else if (s instanceof Selector10Primeros || s instanceof SelectorPodio){
		for (int i=0; i< corredores.size(); i++){
			if (s.selecciona(corredores.get(i)) == true && corredores.get(i) != null){
				Corredores.add(corredores.get(i));
			}

		}
		s.inicia();
	}

	else { System.out.println("Parametro no valido");
	}
	return Corredores;
}
}

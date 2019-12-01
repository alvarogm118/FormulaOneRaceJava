package es.upm.dit.prog.practica5;

public class Selector10Primeros implements Selector {

	public int cont10;
	
	public Selector10Primeros(){
		cont10 = 0;
	}

	@Override
	public boolean selecciona(Corredor c) {
		if (c != null && this.cont10 < 10) {
			this.cont10 ++;
			return true;
		}
		return false;
	}

	@Override
	public void inicia() {
		this.cont10 = 0;
		
	}
	

}

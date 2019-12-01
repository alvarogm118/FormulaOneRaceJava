package es.upm.dit.prog.practica5;

public class SelectorPodio implements Selector {

	public int contPodio;

	public SelectorPodio(){
		contPodio = 0;
	}
	
	@Override
	public boolean selecciona(Corredor c) {
		if (c != null && this.contPodio < 3) {
			this.contPodio ++;
			return true;
		}
		return false;
	}

	@Override
	public void inicia() {
		this.contPodio = 0;
		
	}
	

}

package es.upm.dit.prog.practica5;

public class SelectorTiempoVuelta implements Selector{
	
	public long tiempoVuelta;
	
	public SelectorTiempoVuelta (long _tiempoVuelta){
		this.tiempoVuelta = _tiempoVuelta;
	}

	@Override
	public boolean selecciona(Corredor c) {
		if (c != null && c.gettMejorVuelta() < this.tiempoVuelta)
			return true;
		return false;
	}

	@Override
	public void inicia() {
		// TODO Auto-generated method stub
		
	}
}

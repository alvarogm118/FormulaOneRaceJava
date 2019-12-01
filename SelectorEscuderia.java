package es.upm.dit.prog.practica5;

public class SelectorEscuderia implements Selector {

	public String escuderia;
	
	public SelectorEscuderia(String _escuderia){
		this.escuderia = _escuderia;
	}
	
	@Override
	public boolean selecciona(Corredor c) {
		if (this.escuderia == c.getEscuderia() && c != null)
			return true;
		return false;
	}
	
	@Override
	public void inicia() {
		// TODO Auto-generated method stub

	}

}

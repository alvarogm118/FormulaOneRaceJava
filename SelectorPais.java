package es.upm.dit.prog.practica5;

public class SelectorPais implements Selector {

	public String pais;


	public SelectorPais(String _pais){
		this.pais = _pais;
	}
	
	@Override
	public boolean selecciona(Corredor c) {
		if (this.pais == c.getPais() && c != null)
			return true;
		return false;
	}
	
	@Override
	public void inicia() {
		// TODO Auto-generated method stub

	}

}

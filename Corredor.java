/**
 * 
 */
package es.upm.dit.prog.practica5;
/**
 * @AlvaroGomezMartinez 
 *
 */
public class Corredor { 
	private String nombre;
	private String iniciales;
	private String pais;
	private String escuderia;
	private Estado estado;
	private long tCarrera;
	private long tUltimaVuelta;
	private long tMejorVuelta;
	private int nVueltas; 

	// Fin de atributos
	
public Corredor (String _nombre, String _iniciales, String _pais, String _escuderia)
		 {
		 this.nombre = _nombre; this.iniciales = _iniciales; this.pais = _pais; 
		 this.escuderia = _escuderia;
		 tCarrera = 0; tUltimaVuelta = 0; nVueltas = 0; tMejorVuelta = Long.MAX_VALUE;
		 estado = Estado.ESPERA;
		 } 

	// Fin de Constructor
	
	public String getNombre () {return nombre;}
	public String getIniciales () {return iniciales;}
	public String getPais () {return pais;}
	public String getEscuderia () {return escuderia;}
	public Estado getEstado() {return estado;}
	public long gettCarrera () {return tCarrera;}
	public long gettUltimaVuelta () {return tUltimaVuelta;}
	public long gettMejorVuelta () {return tMejorVuelta;}
	public int getNVueltas () {return nVueltas;}
	
	public void enCarrera () {estado = Estado.ENCARRERA;}
	public void fueraCarrera () {estado = Estado.FUERACARRERA;}
	public void aBoxes () {estado = Estado.ENBOXES;}

	// Fin de Metodos
	
	// Metodo ToString
	
	@Override
	public String toString() {
		return "Corredor [nombre=" + nombre + ", iniciales=" + iniciales + ", pais=" + pais + ", escuderia=" + escuderia
				+ ", estado=" + estado + ", tCarrera=" + tCarrera + ", tUltimaVuelta=" + tUltimaVuelta
				+ ", tMejorVuelta=" + tMejorVuelta + ", nVueltas=" + nVueltas + "]";
	}
	
	// Metodo HashCode
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((escuderia == null) ? 0 : escuderia.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((iniciales == null) ? 0 : iniciales.hashCode());
		result = prime * result + nVueltas;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pais == null) ? 0 : pais.hashCode());
		result = prime * result + (int) (tCarrera ^ (tCarrera >>> 32));
		result = prime * result + (int) (tMejorVuelta ^ (tMejorVuelta >>> 32));
		result = prime * result + (int) (tUltimaVuelta ^ (tUltimaVuelta >>> 32));
		return result;
	}

	// Metodo equals
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corredor other = (Corredor) obj;
		if (escuderia == null) {
			if (other.escuderia != null)
				return false;
		} else if (!escuderia.equals(other.escuderia))
			return false;
		if (estado != other.estado)
			return false;
		if (iniciales == null) {
			if (other.iniciales != null)
				return false;
		} else if (!iniciales.equals(other.iniciales))
			return false;
		if (nVueltas != other.nVueltas)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pais == null) {
			if (other.pais != null)
				return false;
		} else if (!pais.equals(other.pais))
			return false;
		if (tCarrera != other.tCarrera)
			return false;
		if (tMejorVuelta != other.tMejorVuelta)
			return false;
		if (tUltimaVuelta != other.tUltimaVuelta)
			return false;
		return true;
	}

	// Metodo vuelta
	
	public void vuelta (long tUltimaVuelta) {
		this.tUltimaVuelta = tUltimaVuelta;
		tCarrera = tUltimaVuelta + tCarrera;
		tMejorVuelta = Math.min(tUltimaVuelta, tMejorVuelta);
		nVueltas ++;
	}
	
	// Metodo finCarrera
	
	

	public void finCarrera(long t) {
		vuelta(t);
		
		estado = Estado.FINAL;
	}
	
}

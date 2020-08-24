package ec.com.sigc.model;

public class Seccion {
	private Integer seccionId;
	private String seccion;
	private int progresoSeccion;

	public int getProgresoSeccion() {
		return progresoSeccion;
	}

	public void setProgresoSeccion(int progresoSeccion) {
		this.progresoSeccion = progresoSeccion;
	}

	public Integer getSeccionId() {
		return seccionId;
	}

	public void setSeccionId(Integer seccionId) {
		this.seccionId = seccionId;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

}

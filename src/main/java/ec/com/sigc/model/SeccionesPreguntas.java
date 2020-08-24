package ec.com.sigc.model;

import java.util.List;

public class SeccionesPreguntas {
	Integer scId;
	Seccion seccion;
	List<Pregunta> lpreguntas;

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public List<Pregunta> getLpreguntas() {
		return lpreguntas;
	}

	public void setLpreguntas(List<Pregunta> lpreguntas) {
		this.lpreguntas = lpreguntas;
	}

	public Integer getScId() {
		return scId;
	}

	public void setScId(Integer scId) {
		this.scId = scId;
	}


}

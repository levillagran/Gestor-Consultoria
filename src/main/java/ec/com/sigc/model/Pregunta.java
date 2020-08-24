package ec.com.sigc.model;


public class Pregunta {
	private Integer preguntaId;
	private String pregunta;
	private String actividad;
	private String entregable;
	private Boolean respuesta;

	public Integer getPreguntaId() {
		return preguntaId;
	}

	public void setPreguntaId(Integer preguntaId) {
		this.preguntaId = preguntaId;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getEntregable() {
		return entregable;
	}

	public void setEntregable(String entregable) {
		this.entregable = entregable;
	}

	public Boolean getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(Boolean respuesta) {
		this.respuesta = respuesta;
	}

}

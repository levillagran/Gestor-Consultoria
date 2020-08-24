package ec.com.sigc.model;

import java.util.List;

public class SeccionPreguntaProgreso {
	int progresoConsultoria;
	List<SeccionesPreguntas> sp;

	public int getProgresoConsultoria() {
		return progresoConsultoria;
	}

	public void setProgresoConsultoria(int progresoConsultoria) {
		this.progresoConsultoria = progresoConsultoria;
	}

	public List<SeccionesPreguntas> getSp() {
		return sp;
	}

	public void setSp(List<SeccionesPreguntas> sp) {
		this.sp = sp;
	}
}

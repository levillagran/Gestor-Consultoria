package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.Preguntas;

public interface PreguntasServicio {
	public abstract List<Preguntas> findAll();
	public abstract Preguntas findById(Integer backId);
	public abstract void save(Preguntas back);
	public abstract void delete(Preguntas back);
}

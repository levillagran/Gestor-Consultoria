package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.Seccion;

public interface SeccionServicio {
	public abstract List<Seccion> findAll();
	public abstract Seccion findById(Integer backId);
	public abstract void save(Seccion back);
	public abstract void delete(Seccion back);
}

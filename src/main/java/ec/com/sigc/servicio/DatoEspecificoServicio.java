package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.DatoEspecifico;

public interface DatoEspecificoServicio {
	public abstract List<DatoEspecifico> findAll();
	public abstract DatoEspecifico findById(Integer backId);
	public abstract void save(DatoEspecifico back);
	public abstract void delete(DatoEspecifico back);
}

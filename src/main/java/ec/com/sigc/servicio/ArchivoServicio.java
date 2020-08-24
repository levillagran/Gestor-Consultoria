package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.Archivo;

public interface ArchivoServicio {
	public abstract List<Archivo> findAll();
	public abstract Archivo findById(Integer backId);
	public abstract void save(Archivo back);
	public abstract void delete(Archivo back);
}

package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.TipoConsultoria;

public interface TipoConsultoriaServicio {
	public abstract List<TipoConsultoria> findAll();
	public abstract TipoConsultoria findById(Integer tcId);
	public abstract void save(TipoConsultoria tc);
	public abstract void delete(TipoConsultoria tc);
}

package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.EstadoConsultoria;

public interface EstadoConsultoriaServicio {
	public abstract List<EstadoConsultoria> findAll();
	public abstract EstadoConsultoria findById(Integer backId);
	public abstract void save(EstadoConsultoria back);
	public abstract void delete(EstadoConsultoria back);
}

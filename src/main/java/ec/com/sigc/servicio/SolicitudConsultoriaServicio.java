package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.SolicitudConsultoria;

public interface SolicitudConsultoriaServicio {
	public abstract List<SolicitudConsultoria> findAll();
	public abstract SolicitudConsultoria findById(Integer scId);
	public abstract void save(SolicitudConsultoria sc);
	public abstract SolicitudConsultoria saveReturn(SolicitudConsultoria sc);
	public abstract void delete(SolicitudConsultoria sc);
	
}

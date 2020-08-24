package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.DatoComun;

public interface DatoComunServicio {
	public abstract List<DatoComun> findAll();
	public abstract DatoComun findById(Integer backId);
	public abstract void save(DatoComun back);
	public abstract void delete(DatoComun back);
}

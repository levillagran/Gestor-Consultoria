package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.BackOffice;
import ec.com.sigc.entidad.Usuario;

public interface BackOfficeServicio {
	public abstract List<BackOffice> findAll();
	public abstract BackOffice findById(Integer backId);
	public abstract BackOffice findByUsuarioId(Usuario usu);
	public abstract void save(BackOffice back);
	public abstract void delete(BackOffice back);
}

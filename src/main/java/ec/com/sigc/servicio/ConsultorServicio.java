package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.Consultor;
import ec.com.sigc.entidad.Usuario;

public interface ConsultorServicio {
	public abstract List<Consultor> findAll();
	public abstract Consultor findById(Integer consultorId);
	public abstract Consultor findByUsuarioId(Usuario usu);
	public abstract void save(Consultor consultor);
	public abstract void delete(Consultor consultor);
}

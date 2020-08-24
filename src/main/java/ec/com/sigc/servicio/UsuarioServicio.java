package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.Usuario;

public interface UsuarioServicio {
	public abstract List<Usuario> findAll();
	public abstract Usuario findById(Integer usuarioId);
	public abstract void save(Usuario usuario);
	public abstract void delete(Usuario usuario);
}

package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.Usuario;
import ec.com.sigc.repositorio.RoleSysRepositorio;
import ec.com.sigc.repositorio.UsuarioRepositorio;
import ec.com.sigc.servicio.UsuarioServicio;

@Service("usuarioServicio")
public class UsuarioServicioImpl implements UsuarioServicio {

	@Autowired
	@Qualifier("usuarioRepositorio")
	private UsuarioRepositorio usuarioRepositorio;

	@Autowired
	@Qualifier("roleSysRepositorio")
	private RoleSysRepositorio roleSysRepositorio;

	@Override
	public List<Usuario> findAll() {
		return usuarioRepositorio.findAllByRoleId(roleSysRepositorio.findByRol("ADMINISTRADOR"));
	}

	@Override
	public Usuario findById(Integer usuarioId) {
		return usuarioRepositorio.findById(usuarioId).get();
	}

	@Override
	public void save(Usuario usuario) {
		usuarioRepositorio.save(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		usuarioRepositorio.delete(usuario);
	}
}

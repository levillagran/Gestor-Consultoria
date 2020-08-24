package ec.com.sigc.servicio.iml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.Usuario;
import ec.com.sigc.repositorio.UsuarioRepositorio;
import ec.com.sigc.servicio.LoginServicio;

@Service("loginServicio")
public class LoginServicioImpl implements LoginServicio {

	@Autowired
	@Qualifier("usuarioRepositorio")
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public Usuario login(String usuario, String clave) {
		return usuarioRepositorio.findByUsuarioAndClave(usuario, clave);
	}
}

package ec.com.sigc.servicio;

import ec.com.sigc.entidad.Usuario;

public interface LoginServicio {
	public abstract Usuario login(String usuario, String clave);
}

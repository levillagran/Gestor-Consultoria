package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.Cliente;
import ec.com.sigc.entidad.Usuario;

public interface ClienteServicio {
	public abstract List<Cliente> findAll();
	public abstract Cliente findById(Integer clienteId);
	public abstract Cliente findByUsuarioId(Usuario usu);
	public abstract void save(Cliente cliente);
	public abstract void delete(Cliente cliente);
}

package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.Cliente;
import ec.com.sigc.entidad.Usuario;
import ec.com.sigc.repositorio.ClienteRepositorio;
import ec.com.sigc.servicio.ClienteServicio;

@Service("clienteServicio")
public class ClienteServicioImpl implements ClienteServicio {

	@Autowired
	@Qualifier("clienteRepositorio")
	private ClienteRepositorio clienteRepositorio;

	@Override
	public List<Cliente> findAll() {
		return clienteRepositorio.findAll();
	}

	@Override
	public Cliente findById(Integer backId) {
		return clienteRepositorio.findById(backId).get();
	}

	@Override
	public void save(Cliente back) {
		clienteRepositorio.save(back);
	}

	@Override
	public void delete(Cliente back) {
		clienteRepositorio.delete(back);
	}

	@Override
	public Cliente findByUsuarioId(Usuario usu) {
		return clienteRepositorio.findByUserId(usu);
	}
}

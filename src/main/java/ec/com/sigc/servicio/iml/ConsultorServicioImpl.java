package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.Consultor;
import ec.com.sigc.entidad.Usuario;
import ec.com.sigc.repositorio.ConsultorRepositorio;
import ec.com.sigc.servicio.ConsultorServicio;

@Service("consultorServicio")
public class ConsultorServicioImpl implements ConsultorServicio {

	@Autowired
	@Qualifier("consultorRepositorio")
	private ConsultorRepositorio consultorRepositorio;

	@Override
	public List<Consultor> findAll() {
		return consultorRepositorio.findAll();
	}

	@Override
	public Consultor findById(Integer backId) {
		return consultorRepositorio.findById(backId).get();
	}

	@Override
	public void save(Consultor back) {
		consultorRepositorio.save(back);
	}

	@Override
	public void delete(Consultor back) {
		consultorRepositorio.delete(back);
	}

	@Override
	public Consultor findByUsuarioId(Usuario usu) {
		return consultorRepositorio.findAllByUserId(usu);
	}
}

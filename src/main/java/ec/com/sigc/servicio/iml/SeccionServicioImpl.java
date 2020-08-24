package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.Seccion;
import ec.com.sigc.repositorio.SeccionRepositorio;
import ec.com.sigc.servicio.SeccionServicio;

@Service("seccionServicio")
public class SeccionServicioImpl implements SeccionServicio {

	@Autowired
	@Qualifier("seccionRepositorio")
	private SeccionRepositorio seccionRepositorio;

	@Override
	public List<Seccion> findAll() {
		return seccionRepositorio.findAll();
	}

	@Override
	public Seccion findById(Integer backId) {
		return seccionRepositorio.findById(backId).get();
	}

	@Override
	public void save(Seccion back) {
		seccionRepositorio.save(back);
	}

	@Override
	public void delete(Seccion back) {
		seccionRepositorio.delete(back);
	}
}

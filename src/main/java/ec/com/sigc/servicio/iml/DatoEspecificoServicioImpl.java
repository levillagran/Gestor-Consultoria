package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.DatoEspecifico;
import ec.com.sigc.repositorio.DatoEspecificoRepositorio;
import ec.com.sigc.servicio.DatoEspecificoServicio;

@Service("datoEspecificoService")
public class DatoEspecificoServicioImpl implements DatoEspecificoServicio {

	@Autowired
	@Qualifier("datoEspecificoRepositorio")
	private DatoEspecificoRepositorio datoEspecificoRepositorio;

	@Override
	public List<DatoEspecifico> findAll() {
		return datoEspecificoRepositorio.findAll();
	}

	@Override
	public DatoEspecifico findById(Integer backId) {
		return datoEspecificoRepositorio.findById(backId).get();
	}

	@Override
	public void save(DatoEspecifico back) {
		datoEspecificoRepositorio.save(back);
	}

	@Override
	public void delete(DatoEspecifico back) {
		datoEspecificoRepositorio.delete(back);
	}
}

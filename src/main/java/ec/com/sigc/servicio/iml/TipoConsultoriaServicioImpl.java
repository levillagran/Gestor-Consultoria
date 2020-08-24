package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.TipoConsultoria;
import ec.com.sigc.repositorio.TipoConsultoriaRepositorio;
import ec.com.sigc.servicio.TipoConsultoriaServicio;

@Service("tipoConsultoriaServicio")
public class TipoConsultoriaServicioImpl implements TipoConsultoriaServicio {

	@Autowired
	@Qualifier("tipoConsultoriaRepositorio")
	private TipoConsultoriaRepositorio tipoConsultoriaRepositorio;

	@Override
	public List<TipoConsultoria> findAll() {
		return tipoConsultoriaRepositorio.findAll();
	}

	@Override
	public TipoConsultoria findById(Integer tcId) {
		return tipoConsultoriaRepositorio.findById(tcId).get();
	}

	@Override
	public void save(TipoConsultoria tc) {
		tipoConsultoriaRepositorio.save(tc);
	}

	@Override
	public void delete(TipoConsultoria tc) {
		tipoConsultoriaRepositorio.delete(tc);
	}
}

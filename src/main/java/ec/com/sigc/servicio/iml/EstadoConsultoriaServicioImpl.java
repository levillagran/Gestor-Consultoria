package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.EstadoConsultoria;
import ec.com.sigc.repositorio.EstadoConsultoriaRepositorio;
import ec.com.sigc.servicio.EstadoConsultoriaServicio;

@Service("estadoConsultoriaServicio")
public class EstadoConsultoriaServicioImpl implements EstadoConsultoriaServicio {

	@Autowired
	@Qualifier("estadoConsultoriaRepositorio")
	private EstadoConsultoriaRepositorio estadoConsultoriaRepositorio;

	@Override
	public List<EstadoConsultoria> findAll() {
		return estadoConsultoriaRepositorio.findAll();
	}

	@Override
	public EstadoConsultoria findById(Integer backId) {
		return estadoConsultoriaRepositorio.findById(backId).get();
	}

	@Override
	public void save(EstadoConsultoria back) {
		estadoConsultoriaRepositorio.save(back);
	}

	@Override
	public void delete(EstadoConsultoria back) {
		estadoConsultoriaRepositorio.delete(back);
	}
}

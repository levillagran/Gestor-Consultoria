package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.SolicitudConsultoria;
import ec.com.sigc.repositorio.SolicitudConsultoriaRepositorio;
import ec.com.sigc.servicio.SolicitudConsultoriaServicio;

@Service("solicitudConsultoriaServicio")
public class SolicitudConsultoriaServicioImpl implements SolicitudConsultoriaServicio {

	@Autowired
	@Qualifier("solicitudConsultoriaRepositorio")
	private SolicitudConsultoriaRepositorio solicitudConsultoriaRepositorio;

	@Override
	public List<SolicitudConsultoria> findAll() {
		return solicitudConsultoriaRepositorio.findAll();
	}

	@Override
	public SolicitudConsultoria findById(Integer scId) {
		return solicitudConsultoriaRepositorio.findById(scId).get();
	}

	@Override
	public void save(SolicitudConsultoria sc) {
		solicitudConsultoriaRepositorio.save(sc);
	}

	@Override
	public void delete(SolicitudConsultoria sc) {
		solicitudConsultoriaRepositorio.delete(sc);
	}

	@Override
	public SolicitudConsultoria saveReturn(SolicitudConsultoria sc) {
		return solicitudConsultoriaRepositorio.save(sc);
	}

}
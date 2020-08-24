package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.Archivo;
import ec.com.sigc.repositorio.ArchivoRepositorio;
import ec.com.sigc.servicio.ArchivoServicio;

@Service("archivoService")
public class ArchivoServicioImpl implements ArchivoServicio {

	@Autowired
	@Qualifier("archivoRepositorio")
	private ArchivoRepositorio archivoRepositorio;

	@Override
	public List<Archivo> findAll() {
		return archivoRepositorio.findAll();
	}

	@Override
	public Archivo findById(Integer backId) {
		return archivoRepositorio.findById(backId).get();
	}

	@Override
	public void save(Archivo back) {
		archivoRepositorio.save(back);
	}

	@Override
	public void delete(Archivo back) {
		archivoRepositorio.delete(back);
	}
}

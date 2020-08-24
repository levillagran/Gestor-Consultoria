package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.DatoComun;
import ec.com.sigc.repositorio.DatoComunRepositorio;
import ec.com.sigc.servicio.DatoComunServicio;

@Service("datoComunService")
public class DatoComunServicioImpl implements DatoComunServicio {

	@Autowired
	@Qualifier("datoComunRepositorio")
	private DatoComunRepositorio datoComunRepositorio;

	@Override
	public List<DatoComun> findAll() {
		return datoComunRepositorio.findAll();
	}

	@Override
	public DatoComun findById(Integer backId) {
		return datoComunRepositorio.findById(backId).get();
	}

	@Override
	public void save(DatoComun back) {
		datoComunRepositorio.save(back);
	}

	@Override
	public void delete(DatoComun back) {
		datoComunRepositorio.delete(back);
	}
}

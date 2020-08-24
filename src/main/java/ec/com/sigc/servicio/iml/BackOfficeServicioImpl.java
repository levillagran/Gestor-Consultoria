package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.BackOffice;
import ec.com.sigc.entidad.Usuario;
import ec.com.sigc.repositorio.BackOfficeRepositorio;
import ec.com.sigc.servicio.BackOfficeServicio;

@Service("backOfficeServicio")
public class BackOfficeServicioImpl implements BackOfficeServicio {

	@Autowired
	@Qualifier("backOfficeRepositorio")
	private BackOfficeRepositorio backOfficeRepositorio;

	@Override
	public List<BackOffice> findAll() {
		return backOfficeRepositorio.findAll();
	}

	@Override
	public BackOffice findById(Integer backId) {
		return backOfficeRepositorio.findById(backId).get();
	}

	@Override
	public void save(BackOffice back) {
		backOfficeRepositorio.save(back);
	}

	@Override
	public void delete(BackOffice back) {
		backOfficeRepositorio.delete(back);
	}

	@Override
	public BackOffice findByUsuarioId(Usuario usu) {
		return backOfficeRepositorio.findByUserId(usu);
	}
}

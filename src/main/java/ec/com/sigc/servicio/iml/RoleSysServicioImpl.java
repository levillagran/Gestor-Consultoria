package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.RoleSys;
import ec.com.sigc.repositorio.RoleSysRepositorio;
import ec.com.sigc.servicio.RoleSysServicio;

@Service("roleSysService")
public class RoleSysServicioImpl implements RoleSysServicio {

	@Autowired
	@Qualifier("roleSysRepositorio")
	private RoleSysRepositorio roleSysRepositorio;

	@Override
	public List<RoleSys> findAll() {
		return roleSysRepositorio.findAll();
	}

	@Override
	public RoleSys findById(Integer backId) {
		return roleSysRepositorio.findById(backId).get();
	}

	@Override
	public void save(RoleSys back) {
		roleSysRepositorio.save(back);
	}

	@Override
	public void delete(RoleSys back) {
		roleSysRepositorio.delete(back);
	}
}

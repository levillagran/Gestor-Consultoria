package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.RoleSys;

public interface RoleSysServicio {
	public abstract List<RoleSys> findAll();
	public abstract RoleSys findById(Integer backId);
	public abstract void save(RoleSys back);
	public abstract void delete(RoleSys back);
}

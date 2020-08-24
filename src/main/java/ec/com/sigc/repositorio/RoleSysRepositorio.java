package ec.com.sigc.repositorio;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.sigc.entidad.RoleSys;

@Repository("roleSysRepositorio")
public interface RoleSysRepositorio extends JpaRepository<RoleSys, Serializable>{
	public abstract RoleSys findByRol(String rol);
}

package ec.com.sigc.repositorio;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.sigc.entidad.DatoEspecifico;

@Repository("datoEspecificoRepositorio")
public interface DatoEspecificoRepositorio extends JpaRepository<DatoEspecifico, Serializable>{
	
}

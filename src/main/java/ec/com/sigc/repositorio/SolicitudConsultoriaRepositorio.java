package ec.com.sigc.repositorio;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.sigc.entidad.SolicitudConsultoria;

@Repository("solicitudConsultoriaRepositorio")
public interface SolicitudConsultoriaRepositorio extends JpaRepository<SolicitudConsultoria, Serializable>{
	
}

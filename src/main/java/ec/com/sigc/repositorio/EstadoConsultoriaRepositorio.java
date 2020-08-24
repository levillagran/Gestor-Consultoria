package ec.com.sigc.repositorio;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.sigc.entidad.EstadoConsultoria;

@Repository("estadoConsultoriaRepositorio")
public interface EstadoConsultoriaRepositorio extends JpaRepository<EstadoConsultoria, Serializable>{
	public abstract EstadoConsultoria findByEstadoConsultoria(String estadoConsultoria);
}

package ec.com.sigc.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.com.sigc.entidad.Cliente;
import ec.com.sigc.entidad.Informe;

@Repository("informeRepositorio")
public interface InformeRepositorio extends JpaRepository<Informe, Serializable> {
	public abstract List<Informe> findAllByClienteId(Cliente clienteId);

	@Query("select i from Informe i where i.datoComunId.solicitudConsultoriaId.estadoConsultoriaId.estadoConsultoria like :estadoConsultoria ")
	public abstract List<Informe> findInformesSolicitados(@Param("estadoConsultoria") String estadoConsultoria);

	@Query("select i from Informe i where i.consultorId.consultorId = :consultorId and i.datoComunId.solicitudConsultoriaId.estadoConsultoriaId.estadoConsultoria like :estadoConsultoria ")
	public abstract List<Informe> findConsultoriasAsignadas(@Param("consultorId") Integer consultorId,
			@Param("estadoConsultoria") String estadoConsultoria);
}

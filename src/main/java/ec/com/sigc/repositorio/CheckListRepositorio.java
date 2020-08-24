package ec.com.sigc.repositorio;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ec.com.sigc.entidad.CheckList;
import ec.com.sigc.entidad.SolicitudConsultoria;

@Repository("checkListRepositorio")
public interface CheckListRepositorio extends JpaRepository<CheckList, Serializable> {
	public abstract List<CheckList> findAllBySolicitudConsultoriaId(SolicitudConsultoria solicitudConsultoriaId);

	@Query("select ch from CheckList ch where ch.solicitudConsultoriaId.solicitudConsultoriaId = :solicitudConsultoriaId and ch.preguntasId.preguntasId=:preguntasId")
	public abstract CheckList findByConsultoriaIdAndPreguntaId(
			@Param("solicitudConsultoriaId") Integer solicitudConsultoriaId,
			@Param("preguntasId") Integer preguntasId);

}

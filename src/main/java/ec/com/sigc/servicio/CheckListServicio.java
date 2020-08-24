package ec.com.sigc.servicio;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ec.com.sigc.entidad.CheckList;
import ec.com.sigc.entidad.SolicitudConsultoria;

public interface CheckListServicio {
	public abstract List<CheckList> findAll();
	public abstract CheckList findById(Integer checkId);
	public abstract void save(CheckList check);
	public abstract void crear(SolicitudConsultoria sc);
	public abstract void delete(CheckList check);
	public abstract void guardarRespuesta(Integer informeId, Integer preguntaId, String actividad, String entregable,
			MultipartFile file, Boolean respuesta);
}

package ec.com.sigc.servicio.iml;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ec.com.sigc.entidad.Archivo;
import ec.com.sigc.entidad.CheckList;
import ec.com.sigc.entidad.DatoEspecifico;
import ec.com.sigc.entidad.Informe;
import ec.com.sigc.entidad.Preguntas;
import ec.com.sigc.entidad.SolicitudConsultoria;
import ec.com.sigc.repositorio.ArchivoRepositorio;
import ec.com.sigc.repositorio.CheckListRepositorio;
import ec.com.sigc.repositorio.DatoEspecificoRepositorio;
import ec.com.sigc.repositorio.InformeRepositorio;
import ec.com.sigc.repositorio.PreguntasRepositorio;
import ec.com.sigc.repositorio.TipoConsultoriaRepositorio;
import ec.com.sigc.servicio.CheckListServicio;

@Service("checkListServicio")
public class CheckListServicioImpl implements CheckListServicio {

	@Autowired
	@Qualifier("checkListRepositorio")
	private CheckListRepositorio checkListRepositorio;

	@Autowired
	@Qualifier("datoEspecificoRepositorio")
	private DatoEspecificoRepositorio datoEspecificoRepositorio;

	@Autowired
	@Qualifier("preguntasRepositorio")
	private PreguntasRepositorio preguntasRepositorio;

	@Autowired
	@Qualifier("archivoRepositorio")
	private ArchivoRepositorio archivoRepositorio;

	@Autowired
	@Qualifier("tipoConsultoriaRepositorio")
	private TipoConsultoriaRepositorio tipoConsultoriaRepositorio;

	@Autowired
	@Qualifier("informeRepositorio")
	private InformeRepositorio informeRepositorio;

	@Override
	public List<CheckList> findAll() {
		return checkListRepositorio.findAll();
	}

	@Override
	public CheckList findById(Integer checkId) {
		return checkListRepositorio.findById(checkId).get();
	}

	@Override
	public void save(CheckList check) {
		checkListRepositorio.save(check);
	}

	@Override
	public void delete(CheckList check) {
		checkListRepositorio.delete(check);
	}

	@Override
	public void crear(SolicitudConsultoria sc) {
		for (Preguntas pregunta : preguntasRepositorio.findAllByTipoConsultoriaId(sc.getTipoConsultoriaId())) {
			Archivo ar = new Archivo();
			ar = archivoRepositorio.save(ar);
			DatoEspecifico de = new DatoEspecifico();
			de.setArchivoId(ar);
			de.setRespuesta(false);
			if (pregunta.getActividad() != null && pregunta.getActividad() != "") {
				de.setActividad(pregunta.getActividad());
				de.setEntregable(pregunta.getEntregable());
			}
			de = datoEspecificoRepositorio.save(de);
			CheckList chl = new CheckList();
			chl.setSolicitudConsultoriaId(sc);
			chl.setDatoEspecificoId(de);
			chl.setPreguntasId(pregunta);
			checkListRepositorio.save(chl);
		}
	}

	@Override
	public void guardarRespuesta(Integer informeId, Integer preguntaId, String actividad, String entregable,
			MultipartFile file, Boolean respuesta) {
		Informe informe = new Informe();
		Integer scId;
		CheckList chk = new CheckList();
		DatoEspecifico de = new DatoEspecifico();
		Archivo archivo = new Archivo();
		informe = informeRepositorio.findById(informeId).get();
		scId = informe.getDatoComunId().getSolicitudConsultoriaId().getSolicitudConsultoriaId();
		chk = checkListRepositorio.findByConsultoriaIdAndPreguntaId(scId, preguntaId);
		de = chk.getDatoEspecificoId();
		archivo = de.getArchivoId();
		try {
			archivo.setArchivo(file.getBytes());
		} catch (IOException e) {
			System.out.println("archivo no pasado a bite vacio");
			e.printStackTrace();
		}
		archivo.setFileName(file.getName());
		archivo.setFileType(file.getOriginalFilename());
		de.setArchivoId(archivo);
		de.setActividad(actividad);
		de.setEntregable(entregable);
		de.setRespuesta(respuesta);
		chk.setDatoEspecificoId(de);
		checkListRepositorio.save(chk);

	}
}

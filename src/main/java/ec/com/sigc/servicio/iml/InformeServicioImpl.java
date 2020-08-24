package ec.com.sigc.servicio.iml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.CheckList;
import ec.com.sigc.entidad.Cliente;
import ec.com.sigc.entidad.DatoComun;
import ec.com.sigc.entidad.EstadoConsultoria;
import ec.com.sigc.entidad.Informe;
import ec.com.sigc.entidad.Seccion;
import ec.com.sigc.entidad.SolicitudConsultoria;
import ec.com.sigc.model.Pregunta;
import ec.com.sigc.model.SeccionPreguntaProgreso;
import ec.com.sigc.model.SeccionesPreguntas;
import ec.com.sigc.repositorio.CheckListRepositorio;
import ec.com.sigc.repositorio.ClienteRepositorio;
import ec.com.sigc.repositorio.DatoComunRepositorio;
import ec.com.sigc.repositorio.EstadoConsultoriaRepositorio;
import ec.com.sigc.repositorio.InformeRepositorio;
import ec.com.sigc.repositorio.SolicitudConsultoriaRepositorio;
import ec.com.sigc.servicio.InformeServicio;

@Service("informeServicio")
public class InformeServicioImpl implements InformeServicio {

	@Autowired
	@Qualifier("informeRepositorio")
	private InformeRepositorio informeRepositorio;

	@Autowired
	@Qualifier("datoComunRepositorio")
	private DatoComunRepositorio datoComunRepositorio;

	@Autowired
	@Qualifier("clienteRepositorio")
	private ClienteRepositorio clienteRepositorio;

	@Autowired
	@Qualifier("estadoConsultoriaRepositorio")
	private EstadoConsultoriaRepositorio estadoConsultoriaRepositorio;

	@Autowired
	@Qualifier("checkListRepositorio")
	private CheckListRepositorio checkListRepositorio;

	@Autowired
	@Qualifier("solicitudConsultoriaRepositorio")
	private SolicitudConsultoriaRepositorio solicitudConsultoriaRepositorio;

	@Override
	public List<Informe> findAll() {
		return informeRepositorio.findAll();
	}

	@Override
	public Informe findById(Integer informeId) {
		return informeRepositorio.findById(informeId).get();
	}

	@Override
	public void save(Informe informe) {
		informeRepositorio.save(informe);
	}

	@Override
	public void delete(Informe informe) {
		informeRepositorio.delete(informe);
	}

	@Override
	public void save(Integer clienteId, SolicitudConsultoria sc) {
		DatoComun dc = new DatoComun();
		dc.setSolicitudConsultoriaId(sc);
		dc = datoComunRepositorio.save(dc);
		Informe in = new Informe();
		in.setDatoComunId(dc);
		in.setClienteId(clienteRepositorio.findById(clienteId).get());
		informeRepositorio.save(in);
	}

	@Override
	public List<Informe> findAll(Cliente clienteId) {
		return informeRepositorio.findAllByClienteId(clienteId);
	}

	@Override
	public List<Informe> findAllByEstadoConsultoria(String estadoConsultoria) {
		return informeRepositorio.findInformesSolicitados(estadoConsultoria);
	}

	@Override
	public List<Informe> findAllByConsultor(Integer consultorId, String estadoConsultoria) {
		return informeRepositorio.findConsultoriasAsignadas(consultorId, estadoConsultoria);
	}

	@Override
	public List<SeccionesPreguntas> listaSeccionesPreguntas(Integer informeId) {
		Informe in = new Informe();
		SolicitudConsultoria sc = new SolicitudConsultoria();
		List<CheckList> chs = new ArrayList<CheckList>();
		List<SeccionesPreguntas> lsp = new ArrayList<SeccionesPreguntas>();
		in = informeRepositorio.findById(informeId).get();
		sc = in.getDatoComunId().getSolicitudConsultoriaId();
		if (sc.getEstadoConsultoriaId().getEstadoConsultoria().equals("ASIGNADA")) {
			cambioEstado(informeId, "");
		}
		chs = checkListRepositorio.findAllBySolicitudConsultoriaId(sc);

		// tomo las secciones del checklist
		List<Seccion> secciones = new ArrayList<Seccion>();
		for (CheckList ch : chs) {
			secciones.add(ch.getPreguntasId().getSeccionId());
		}
		List<Seccion> seccionesNoRep = new ArrayList<Seccion>();
		Map<Integer, Seccion> aux = new HashMap<Integer, Seccion>(secciones.size());
		// relleno el mapList con las secciones con repetidas
		for (Seccion seccion : secciones) {
			aux.put(seccion.getSeccionId(), seccion);
		}
		// relleno con secciones no repetidas
		for (Entry<Integer, Seccion> seccion : aux.entrySet()) {
			seccionesNoRep.add(seccion.getValue());
		}
		// relleno las preguntas
		for (Seccion seccion : seccionesNoRep) {
			List<Pregunta> preguntasSeccion = new ArrayList<Pregunta>();
			for (CheckList ch : chs) {
				if (seccion.equals(ch.getPreguntasId().getSeccionId())) {
					Pregunta pregunta = new Pregunta();
					pregunta.setPreguntaId(ch.getPreguntasId().getPreguntasId());
					pregunta.setPregunta(ch.getPreguntasId().getPreguntas());
					pregunta.setActividad(ch.getDatoEspecificoId().getActividad());
					pregunta.setEntregable(ch.getDatoEspecificoId().getEntregable());
					pregunta.setRespuesta(ch.getDatoEspecificoId().isRespuesta());
					preguntasSeccion.add(pregunta);
				}
			}
			SeccionesPreguntas sp = new SeccionesPreguntas();
			ec.com.sigc.model.Seccion seccionModal = new ec.com.sigc.model.Seccion();
			seccionModal.setSeccionId(seccion.getSeccionId());
			seccionModal.setSeccion(seccion.getSeccion());
			sp.setScId(sc.getSolicitudConsultoriaId());
			sp.setSeccion(seccionModal);
			sp.setLpreguntas(preguntasSeccion);
			lsp.add(sp);
		}

		return lsp;
	}

	@Override
	public List<SeccionesPreguntas> progresoSeccion(List<SeccionesPreguntas> sp) {
		float i = 0;
		float j = 0;
		for (SeccionesPreguntas seccionPregunta : sp) {
			ec.com.sigc.model.Seccion seccion = new ec.com.sigc.model.Seccion();
			for (Pregunta pregunta : seccionPregunta.getLpreguntas()) {
				j++;
				if (pregunta.getRespuesta()) {
					i++;
				}
			}
			seccion = seccionPregunta.getSeccion();
			seccion.setProgresoSeccion((int) ((i / j) * 100));
			seccionPregunta.setSeccion(seccion);
			i = 0;
			j = 0;
		}
		return sp;
	}

	@Override
	public SeccionPreguntaProgreso progresocConsultoria(List<SeccionesPreguntas> sp) {
		float i = 0;
		float j = 0;
		SeccionPreguntaProgreso spp = new SeccionPreguntaProgreso();
		for (SeccionesPreguntas seccionPregunta : sp) {
			for (Pregunta pregunta : seccionPregunta.getLpreguntas()) {
				j++;
				if (pregunta.getRespuesta()) {
					i++;
				}
			}
		}
		spp.setProgresoConsultoria((int) ((i / j) * 100));
		spp.setSp(sp);
		return spp;
	}

	@Override
	public void cambioEstado(Integer informeId, String accion) {
		Informe in = new Informe();
		SolicitudConsultoria sc = new SolicitudConsultoria();
		in = informeRepositorio.findById(informeId).get();
		sc = in.getDatoComunId().getSolicitudConsultoriaId();
		if (sc.getEstadoConsultoriaId().getEstadoConsultoria().equals("SOLICITADA")) {
			EstadoConsultoria ec = new EstadoConsultoria();
			ec = estadoConsultoriaRepositorio.findByEstadoConsultoria("ASIGNADA");
			sc.setEstadoConsultoriaId(ec);
			solicitudConsultoriaRepositorio.save(sc);
		} else if (sc.getEstadoConsultoriaId().getEstadoConsultoria().equals("ASIGNADA")) {
			EstadoConsultoria ec = new EstadoConsultoria();
			ec = estadoConsultoriaRepositorio.findByEstadoConsultoria("EN PROCESO");
			sc.setEstadoConsultoriaId(ec);
			solicitudConsultoriaRepositorio.save(sc);
		} else if (sc.getEstadoConsultoriaId().getEstadoConsultoria().equals("EN PROCESO")) {
			EstadoConsultoria ec = new EstadoConsultoria();
			ec = estadoConsultoriaRepositorio.findByEstadoConsultoria("EN ESPERA DE EVIDENCIA");
			sc.setEstadoConsultoriaId(ec);
			solicitudConsultoriaRepositorio.save(sc);
		} else if (sc.getEstadoConsultoriaId().getEstadoConsultoria().equals("EN ESPERA DE EVIDENCIA")) {
			EstadoConsultoria ec = new EstadoConsultoria();
			ec = estadoConsultoriaRepositorio.findByEstadoConsultoria("REVISANDO EVIDENCIA");
			sc.setEstadoConsultoriaId(ec);
			solicitudConsultoriaRepositorio.save(sc);
		} else if (sc.getEstadoConsultoriaId().getEstadoConsultoria().equals("REVISANDO EVIDENCIA")
				&& accion == "siguiente") {
			EstadoConsultoria ec = new EstadoConsultoria();
			ec = estadoConsultoriaRepositorio.findByEstadoConsultoria("FINALIZADA");
			sc.setEstadoConsultoriaId(ec);
			solicitudConsultoriaRepositorio.save(sc);
		} else {
			EstadoConsultoria ec = new EstadoConsultoria();
			ec = estadoConsultoriaRepositorio.findByEstadoConsultoria("EN ESPERA DE EVIDENCIA");
			sc.setEstadoConsultoriaId(ec);
			solicitudConsultoriaRepositorio.save(sc);
		}

	}

	@Override
	public List<SeccionesPreguntas> listaSeccionesPreguntasNo(Integer informeId) {
		Informe in = new Informe();
		SolicitudConsultoria sc = new SolicitudConsultoria();
		List<CheckList> chs = new ArrayList<CheckList>();
		List<SeccionesPreguntas> lsp = new ArrayList<SeccionesPreguntas>();
		in = informeRepositorio.findById(informeId).get();
		sc = in.getDatoComunId().getSolicitudConsultoriaId();
		chs = checkListRepositorio.findAllBySolicitudConsultoriaId(sc);

		// tomo las secciones del checklist
		List<Seccion> secciones = new ArrayList<Seccion>();
		for (CheckList ch : chs) {
			secciones.add(ch.getPreguntasId().getSeccionId());
		}
		List<Seccion> seccionesNoRep = new ArrayList<Seccion>();
		Map<Integer, Seccion> aux = new HashMap<Integer, Seccion>(secciones.size());
		// relleno el mapList con las secciones con repetidas
		for (Seccion seccion : secciones) {
			aux.put(seccion.getSeccionId(), seccion);
		}
		// relleno con secciones no repetidas
		for (Entry<Integer, Seccion> seccion : aux.entrySet()) {
			seccionesNoRep.add(seccion.getValue());
		}
		// relleno las preguntas
		for (Seccion seccion : seccionesNoRep) {
			List<Pregunta> preguntasSeccion = new ArrayList<Pregunta>();
			for (CheckList ch : chs) {
				if (seccion.equals(ch.getPreguntasId().getSeccionId())) {
					if (ch.getDatoEspecificoId().isRespuesta()) {
					} else {
						Pregunta pregunta = new Pregunta();
						pregunta.setPreguntaId(ch.getPreguntasId().getPreguntasId());
						pregunta.setPregunta(ch.getPreguntasId().getPreguntas());
						pregunta.setActividad(ch.getDatoEspecificoId().getActividad());
						pregunta.setEntregable(ch.getDatoEspecificoId().getEntregable());
						pregunta.setRespuesta(ch.getDatoEspecificoId().isRespuesta());
						preguntasSeccion.add(pregunta);
					}
				}
			}
			SeccionesPreguntas sp = new SeccionesPreguntas();
			ec.com.sigc.model.Seccion seccionModal = new ec.com.sigc.model.Seccion();
			seccionModal.setSeccionId(seccion.getSeccionId());
			seccionModal.setSeccion(seccion.getSeccion());
			sp.setScId(sc.getSolicitudConsultoriaId());
			sp.setSeccion(seccionModal);
			sp.setLpreguntas(preguntasSeccion);
			lsp.add(sp);
		}
		return lsp;
	}

}

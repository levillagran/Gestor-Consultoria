package ec.com.sigc.controlador;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ec.com.sigc.entidad.Consultor;
import ec.com.sigc.model.SeccionPreguntaProgreso;
import ec.com.sigc.model.SeccionesPreguntas;
import ec.com.sigc.servicio.CheckListServicio;
import ec.com.sigc.servicio.ConsultorServicio;
import ec.com.sigc.servicio.InformeServicio;
import ec.com.sigc.servicio.UsuarioServicio;

@Controller
@RequestMapping(path = "/consultor")
public class DashboardConsultorController {

	@Autowired
	@Qualifier("usuarioServicio")
	private UsuarioServicio usuarioServicio;

	@Autowired
	@Qualifier("consultorServicio")
	private ConsultorServicio consultorServicio;

	@Autowired
	@Qualifier("checkListServicio")
	private CheckListServicio checkListServicio;

	@Autowired
	@Qualifier("informeServicio")
	private InformeServicio informeServicio;

	@GetMapping(value = "/asignada_consultoria")
	public ModelAndView consultoriasAsignadas(ModelAndView mv, Integer consultorId) {
		Consultor consultor = new Consultor();
		consultor = consultorServicio.findById(consultorId);
		mv.addObject("usuarioCons", consultor);
		mv.addObject("consultorias", informeServicio.findAllByConsultor(consultorId, "ASIGNADA"));
		mv.setViewName("consultor/asignada_consultoria");
		return mv;
	}
	
	@GetMapping(value = "/curso_consultoria")
	public ModelAndView consultoriasCursoAsignadas(ModelAndView mv, Integer consultorId) {
		Consultor consultor = new Consultor();
		consultor = consultorServicio.findById(consultorId);
		mv.addObject("usuarioCons", consultor);
		mv.addObject("consultorias", informeServicio.findAllByConsultor(consultorId, "EN PROCESO"));
		mv.addObject("consultoriasEvidencia", informeServicio.findAllByConsultor(consultorId, "EN ESPERA DE EVIDENCIA"));
		mv.setViewName("consultor/curso_consultoria");
		return mv;
	}
	
	@GetMapping(value = "/enviar_consultoria")
	public ModelAndView enviarConsultoriasAsignadas(ModelAndView mv, Integer consultorId, Integer informeId) {
		Consultor consultor = new Consultor();
		consultor = consultorServicio.findById(consultorId);
		informeServicio.cambioEstado(informeId, "");
		mv.addObject("usuarioCons", consultor);		
		mv.setViewName("consultor/curso_consultoria");
		return mv;
	}
	
	@GetMapping(value = "/revisar_consultoria")
	public ModelAndView consultoriasRevisar(ModelAndView mv, Integer consultorId) {
		Consultor consultor = new Consultor();
		consultor = consultorServicio.findById(consultorId);
		mv.addObject("usuarioCons", consultor);
		mv.addObject("consultorias", informeServicio.findAllByConsultor(consultorId, "REVISANDO EVIDENCIA"));
		mv.setViewName("consultor/revisar_consultoria");
		return mv;
	}

	@GetMapping(value = "/formulario_consultoria")
	public ModelAndView asignarConsul(ModelAndView mv, Integer informeId, Integer consultorId) {
		List<SeccionesPreguntas> sp = new ArrayList<SeccionesPreguntas>();
		SeccionPreguntaProgreso spp = new SeccionPreguntaProgreso();
		sp = informeServicio.listaSeccionesPreguntas(informeId);
		sp = informeServicio.progresoSeccion(sp);
		spp = informeServicio.progresocConsultoria(sp);
		mv.addObject("seccionesPreguntasPorcentaje", spp);
		mv.addObject("consultoria", informeServicio.findById(informeId));
		mv.addObject("usuarioCons", consultorServicio.findById(consultorId));
		mv.setViewName("consultor/formulario_consultoria");
		return mv;
	}

	@PostMapping(value = "/guardarPreguntaRespuesta")
	public String guardarPreguntaRespuesta(Model mv, Integer preguntaId, Integer consultorId,
			Integer informeId, String actividad, String entregable, MultipartFile file, Boolean respuesta) {
		List<SeccionesPreguntas> sp = new ArrayList<SeccionesPreguntas>();
		SeccionPreguntaProgreso spp = new SeccionPreguntaProgreso();
		
		checkListServicio.guardarRespuesta(informeId, preguntaId, actividad, entregable, file, respuesta);
		
		sp = informeServicio.listaSeccionesPreguntas(informeId);
		sp = informeServicio.progresoSeccion(sp);
		spp = informeServicio.progresocConsultoria(sp);
		
		mv.addAttribute("usuarioCons", consultorServicio.findById(consultorId));
		mv.addAttribute("seccionesPreguntasPorcentaje", spp);
		mv.addAttribute("consultoria", informeServicio.findById(informeId));

		return "consultor/formulario_consultoria";
	}

	@GetMapping(value = "/revisar-consultoria")
	public String revisarConsultoria(Model model) {
		model.addAttribute("administradores", usuarioServicio.findAll());
		return "consultor/revisar_consultoria";
	}

	@GetMapping(value = "/realizada_consultoria")
	public ModelAndView consultoriasFinalisadas(ModelAndView mv, Integer consultorId) {
		Consultor consultor = new Consultor();
		consultor = consultorServicio.findById(consultorId);
		mv.addObject("usuarioCons", consultor);
		mv.addObject("consultorias", informeServicio.findAllByConsultor(consultorId, "FINALIZADA"));
		mv.setViewName("consultor/realizada_consultoria");
		return mv;
	}

}

package ec.com.sigc.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.com.sigc.entidad.Cliente;
import ec.com.sigc.entidad.SolicitudConsultoria;
import ec.com.sigc.model.SeccionPreguntaProgreso;
import ec.com.sigc.model.SeccionesPreguntas;
import ec.com.sigc.servicio.CheckListServicio;
import ec.com.sigc.servicio.ClienteServicio;
import ec.com.sigc.servicio.EstadoConsultoriaServicio;
import ec.com.sigc.servicio.InformeServicio;
import ec.com.sigc.servicio.SolicitudConsultoriaServicio;
import ec.com.sigc.servicio.TipoConsultoriaServicio;

@Controller
@RequestMapping(path = "/cliente")
public class DashboardClienteController {

	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServicio clienteServicio;

	@Autowired
	@Qualifier("tipoConsultoriaServicio")
	private TipoConsultoriaServicio tipoConsultoriaServicio;

	@Autowired
	@Qualifier("solicitudConsultoriaServicio")
	private SolicitudConsultoriaServicio solicitudConsultoriaServicio;

	@Autowired
	@Qualifier("estadoConsultoriaServicio")
	private EstadoConsultoriaServicio estadoConsultoriaServicio;

	@Autowired
	@Qualifier("checkListServicio")
	private CheckListServicio checkListServicio;
	
	@Autowired
	@Qualifier("informeServicio")
	private InformeServicio informeServicio;

	@GetMapping(value = "/perfil_cliente")
	public ModelAndView perfilCliente(ModelAndView mv, Integer clienteId) {
		mv.addObject("usuarioCli", clienteServicio.findById(clienteId));
		mv.setViewName("cliente/perfil_cliente");
		return mv;
	}

	@GetMapping(value = "/solicitud_consultoria")
	public ModelAndView solicitudConsultorias(ModelAndView mv, Integer clienteId) {
		mv.addObject("usuarioCli", clienteServicio.findById(clienteId));
		mv.addObject("tipoConsultorias", tipoConsultoriaServicio.findAll());
		mv.setViewName("cliente/solicitud_consultoria");
		return mv;
	}

	@PostMapping(value = "/saveSolicitudConsultoria")
	public ModelAndView saveSolicitudConsultoria(ModelAndView mv, Integer clienteId, String tipoConsultoriaId,
			String fechaInicio, String fechaFin, BindingResult bindingResult, RedirectAttributes redirectAttrs) {
		try {
			SolicitudConsultoria sc = new SolicitudConsultoria();
			sc.setFechaInicio(new SimpleDateFormat("yyy-MM-dd").parse(fechaInicio));
			sc.setFechaFinal(new SimpleDateFormat("yyy-MM-dd").parse(fechaFin));
			sc.setTipoConsultoriaId(tipoConsultoriaServicio.findById(Integer.parseInt(tipoConsultoriaId)));
			sc.setEstadoConsultoriaId(estadoConsultoriaServicio.findById(1));
			sc = solicitudConsultoriaServicio.saveReturn(sc);
			mv.addObject("mensaje", "Solicitud enviada correctamente");
			mv.addObject("clase", "success");
			try {
				checkListServicio.crear(sc);
				mv.addObject("mensaje1", "creó checklist");
			} catch (Exception e) {
				mv.addObject("mensaje1", "incorrecto, no creó checklist");
			}
			try {
				informeServicio.save(clienteId, sc);
				mv.addObject("mensaje2", "creó informe");
			} catch (Exception e) {
				mv.addObject("mensaje2", "incorrecto, no creó informe");
			}

		} catch (ParseException e) {
			mv.addObject("mensaje", "Solicitud fallida, rellene todos los campos");
			mv.addObject("clase", "danger");
		}
		mv.addObject("usuarioCli", clienteServicio.findById(clienteId));
		mv.addObject("tipoConsultorias", tipoConsultoriaServicio.findAll());
		mv.setViewName("cliente/solicitud_consultoria");

		return mv;
	}

	@GetMapping(value = "/consulta_consultorias")
	public ModelAndView consultaConsultorias(ModelAndView mv, Integer clienteId) {
		Cliente cli = new Cliente();
		cli = clienteServicio.findById(clienteId);
		mv.addObject("consultorias", informeServicio.findAll(cli));
		mv.addObject("usuarioCli", cli);
		mv.setViewName("cliente/consulta_consultoria");
		return mv;
	}

	@GetMapping(value = "/resumen_consultoria")
	public ModelAndView listarAdmin(ModelAndView mv, Integer clienteId, Integer consultoriaId) {
		System.out.println(clienteId);
		System.out.println(consultoriaId);
		//mv.addObject("administradores", usuarioServicio.findAll());
		mv.addObject("usuarioCli", clienteServicio.findById(clienteId));
		mv.setViewName("cliente/resumen_consultoria");
		return mv;
	}

	@GetMapping(value = "/formulario_consultoria_carga_evidencia")
	public ModelAndView asignarConsul(ModelAndView mv, Integer informeId, Integer clienteId) {
		System.out.println(informeId);
		List<SeccionesPreguntas> sp = new ArrayList<SeccionesPreguntas>();
		SeccionPreguntaProgreso spp = new SeccionPreguntaProgreso();
		sp = informeServicio.listaSeccionesPreguntasNo(informeId);
		sp = informeServicio.progresoSeccion(sp);
		spp = informeServicio.progresocConsultoria(sp);
		mv.addObject("seccionesPreguntasPorcentaje", spp);
		mv.addObject("consultoria", informeServicio.findById(informeId));
		mv.addObject("usuarioCli", clienteServicio.findById(clienteId));
		mv.setViewName("cliente/formulario_consultoria_carga_evidencia");
		return mv;
	}

}

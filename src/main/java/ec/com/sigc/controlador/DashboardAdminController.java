package ec.com.sigc.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import ec.com.sigc.servicio.BackOfficeServicio;
import ec.com.sigc.servicio.ClienteServicio;
import ec.com.sigc.servicio.ConsultorServicio;
import ec.com.sigc.servicio.PreguntasServicio;
import ec.com.sigc.servicio.SeccionServicio;
import ec.com.sigc.servicio.SolicitudConsultoriaServicio;
import ec.com.sigc.servicio.TipoConsultoriaServicio;
import ec.com.sigc.servicio.UsuarioServicio;

@Controller
@RequestMapping(path = "/admin")
public class DashboardAdminController {

	@Autowired
	@Qualifier("solicitudConsultoriaServicio")
	private SolicitudConsultoriaServicio solicitudConsultoriaServicio;
	
	@Autowired
	@Qualifier("usuarioServicio")
	private UsuarioServicio usuarioServicio;
	
	@Autowired
	@Qualifier("backOfficeServicio")
	private BackOfficeServicio backOfficeServicio;
	
	@Autowired
	@Qualifier("consultorServicio")
	private ConsultorServicio consultorServicio;

	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServicio clienteServicio;
	
	@Autowired
	@Qualifier("tipoConsultoriaServicio")
	private TipoConsultoriaServicio tipoConsultoriaServicio;
	
	@Autowired
	@Qualifier("seccionServicio")
	private SeccionServicio seccionServicio;
	
	@Autowired
	@Qualifier("preguntasServicio")
	private PreguntasServicio preguntasServicio;
	
	@GetMapping(value = "/listar-solicitud-consultorias")
	public String listarSolicitudConsultorias(Model model) {
		model.addAttribute("solicituConsultorias", solicitudConsultoriaServicio.findAll());
		return "admin/tabla_solicitud";
	}
	
	@GetMapping(value = "/listar-consultorias")
	public String listarConsultorias(Model model) {
		model.addAttribute("Consultorias", solicitudConsultoriaServicio.findAll());
		return "admin/tabla_consultoria";
	}

	@GetMapping(value = "/listar-administradores")
	public String listarAdmin(Model model) {
		model.addAttribute("administradores", usuarioServicio.findAll());
		return "admin/tabla_admin";
	}
	
	@GetMapping(value = "/listar-back-office")
	public String listarBack(Model model) {
		model.addAttribute("backOffices", backOfficeServicio.findAll());
		return "admin/tabla_backoffice";
	}
	
	@GetMapping(value = "/listar-consultores")
	public String listarConsultores(Model model) {
		model.addAttribute("consultores", consultorServicio.findAll());
		return "admin/tabla_consultor";
	}
	
	@GetMapping(value = "/listar-clientes")
	public String listarClientes(Model model) {
		model.addAttribute("clientes", clienteServicio.findAll());
		return "admin/tabla_cliente";
	}
	
	@GetMapping(value = "/listar-tipo-consultorias")
	public String listarTiposConsultorias(Model model) {
		model.addAttribute("tipoConsultorias", tipoConsultoriaServicio.findAll());
		return "admin/tabla_tipo_consultoria";
	}
	
	@GetMapping(value = "/listar-secciones")
	public String listarSecciones(Model model) {
		model.addAttribute("tipoConsultorias", tipoConsultoriaServicio.findAll());
		model.addAttribute("secciones", seccionServicio.findAll());
		return "admin/tabla_seccion";
	}
	
	@GetMapping(value = "/listar-preguntas")
	public String listarPreguntas(Model model) {
		model.addAttribute("tipoConsultorias", tipoConsultoriaServicio.findAll());
		model.addAttribute("secciones", seccionServicio.findAll());
		model.addAttribute("preguntas", preguntasServicio.findAll());
		return "admin/tabla_pregunta";
	}

}

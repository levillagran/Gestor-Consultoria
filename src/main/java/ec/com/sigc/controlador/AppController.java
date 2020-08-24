package ec.com.sigc.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ec.com.sigc.entidad.Usuario;
import ec.com.sigc.servicio.BackOfficeServicio;
import ec.com.sigc.servicio.ClienteServicio;
import ec.com.sigc.servicio.ConsultorServicio;
import ec.com.sigc.servicio.LoginServicio;
import ec.com.sigc.servicio.UsuarioServicio;

@Controller
public class AppController {
	
	@Autowired
	@Qualifier("loginServicio")
	private LoginServicio loginServicio;
	
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
	
    @GetMapping("/")
	public String showLogin() {
		return "app/login";
	}
	
	@PostMapping("/app/autenticcion")
	public ModelAndView listarSolicitudConsultorias(String usuario, String clave) {
		ModelAndView mv = new ModelAndView();
		Usuario usu = new Usuario();
		usu = loginServicio.login(usuario, clave);
		if (usu != null) {
			switch (usu.getRoleId().getRol()) {
			case "ADMINISTRADOR":
				mv.addObject("usuarioAdmin", usu);
				mv.setViewName("/admin/listar-administradores");
				return mv;
			case "BACK-OFFICE":
				mv.addObject("usuarioBack", backOfficeServicio.findByUsuarioId(usu));
				mv.setViewName("/backoffice/tabla_nueva_consultoria");
				return mv;
			case "CONSULTOR":
				mv.addObject("usuarioCons", consultorServicio.findByUsuarioId(usu));
				mv.setViewName("/consultor/asignada_consultoria");
				return mv;
			case "CLIENTE":
				mv.addObject("usuarioCli", clienteServicio.findByUsuarioId(usu));
				mv.setViewName("/cliente/perfil_cliente");
				return mv;
			default:
				mv.setViewName("/app/login_registro");
				return mv;
			}
		} else {
			mv.setViewName("/app/login_registro");
			return mv;
		}
	}
}

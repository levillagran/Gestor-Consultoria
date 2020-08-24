package ec.com.sigc.controlador;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import ec.com.sigc.entidad.BackOffice;
import ec.com.sigc.entidad.Consultor;
import ec.com.sigc.entidad.DatoComun;
import ec.com.sigc.entidad.Informe;
import ec.com.sigc.entidad.SolicitudConsultoria;
import ec.com.sigc.servicio.BackOfficeServicio;
import ec.com.sigc.servicio.ClienteServicio;
import ec.com.sigc.servicio.ConsultorServicio;
import ec.com.sigc.servicio.EstadoConsultoriaServicio;
import ec.com.sigc.servicio.InformeServicio;

@Controller
@RequestMapping(path = "/backoffice")
public class DashboardBackOfficeController {

	@Autowired
	@Qualifier("clienteServicio")
	private ClienteServicio clienteServicio;

	@Autowired
	@Qualifier("backOfficeServicio")
	private BackOfficeServicio backOfficeServicio;

	@Autowired
	@Qualifier("informeServicio")
	private InformeServicio informeServicio;

	@Autowired
	@Qualifier("consultorServicio")
	private ConsultorServicio consultorServicio;
	
	@Autowired
	@Qualifier("estadoConsultoriaServicio")
	private EstadoConsultoriaServicio estadoConsultoriaServicio;

	/*
	 * @GetMapping(value = "/perfil-back-office") public String perfilCliente(Model
	 * model) { model.addAttribute("backoffice", usuarioServicio.findAll()); return
	 * "back-office/perfil_back_office"; }
	 */

	@GetMapping(value = "/tabla_nueva_consultoria")
	public ModelAndView nuevasConsultorias(ModelAndView mv, Integer backOfficeId) {
		mv.addObject("usuarioBack", backOfficeServicio.findById(backOfficeId));
		mv.addObject("consultorias", informeServicio.findAllByEstadoConsultoria("SOLICITADA"));
		mv.setViewName("backoffice/tabla_nueva_consultoria");
		return mv;
	}

	@GetMapping(value = "/asignar_solicitud_consultoria")
	public ModelAndView asignarConsultoria(ModelAndView mv, Integer backOfficeId, Integer informeId) {
		mv.addObject("usuarioBack", backOfficeServicio.findById(backOfficeId));
		mv.addObject("consultoria", informeServicio.findById(informeId));
		mv.addObject("consultores", consultorServicio.findAll());
		mv.setViewName("backoffice/asignar_solicitud_consultoria");
		return mv;
	}

	@PostMapping(value = "/asignarConsultoria")
	public ModelAndView asignarConsul(ModelAndView mv, Integer backOfficeId, Integer informeId, Integer consultorId,
			String fechaInicio, String fechaFin) {
		Informe in = new Informe();
		DatoComun dc = new DatoComun();
		SolicitudConsultoria sc = new SolicitudConsultoria();
		Consultor consultor = new Consultor();
		BackOffice back = new BackOffice();
		try {
			in = informeServicio.findById(informeId);
			dc = in.getDatoComunId();
			sc = dc.getSolicitudConsultoriaId();
			sc.setFechaInicio(new SimpleDateFormat("yyy-MM-dd").parse(fechaInicio));
			sc.setFechaFinal(new SimpleDateFormat("yyy-MM-dd").parse(fechaFin));
			sc.setEstadoConsultoriaId(estadoConsultoriaServicio.findById(2));
			dc.setSolicitudConsultoriaId(sc);
			in.setDatoComunId(dc);
			consultor = consultorServicio.findById(consultorId);
			in.setConsultorId(consultor);
			back = backOfficeServicio.findById(backOfficeId);
			in.setBackOfficeId(back);
			informeServicio.save(in);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		mv.addObject("usuarioBack", back);
		mv.addObject("consultorias", informeServicio.findAllByEstadoConsultoria("SOLICITADA"));
		mv.setViewName("backoffice/tabla_nueva_consultoria");
		return mv;
	}

	@GetMapping(value = "/tabla_consultoria_asignada")
	public ModelAndView todasConsultorias(ModelAndView mv, Integer backOfficeId) {
		mv.addObject("usuarioBack", backOfficeServicio.findById(backOfficeId));
		mv.addObject("consultorias", informeServicio.findAll());
		mv.setViewName("backoffice/tabla_consultoria_asignada");
		return mv;
	}
	
}

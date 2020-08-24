package ec.com.sigc.servicio;

import java.util.List;

import ec.com.sigc.entidad.Cliente;
import ec.com.sigc.entidad.Informe;
import ec.com.sigc.entidad.SolicitudConsultoria;
import ec.com.sigc.model.SeccionPreguntaProgreso;
import ec.com.sigc.model.SeccionesPreguntas;

public interface InformeServicio {
	public abstract List<Informe> findAll();
	public abstract List<Informe> findAll(Cliente clienteId);
	public abstract List<Informe> findAllByEstadoConsultoria(String estadoConsultoria);
	public abstract List<Informe> findAllByConsultor(Integer consultorId, String estadoConsultoria);
	
	public abstract List<SeccionesPreguntas> listaSeccionesPreguntas(Integer informeId);
	public abstract List<SeccionesPreguntas> listaSeccionesPreguntasNo(Integer informeId);
	
	public abstract Informe findById(Integer informeId);
	public abstract void save(Informe informe);
	public abstract void save(Integer clienteId, SolicitudConsultoria sc);
	public abstract void delete(Informe informe);
	public abstract List<SeccionesPreguntas> progresoSeccion(List<SeccionesPreguntas> sp);
	public abstract SeccionPreguntaProgreso progresocConsultoria(List<SeccionesPreguntas> sp);
	public abstract void cambioEstado(Integer informeId, String accion);
	
}

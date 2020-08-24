package ec.com.sigc.servicio.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ec.com.sigc.entidad.Preguntas;
import ec.com.sigc.repositorio.PreguntasRepositorio;
import ec.com.sigc.servicio.PreguntasServicio;

@Service("preguntasServicio")
public class PreguntasServicioImpl implements PreguntasServicio {

	@Autowired
	@Qualifier("preguntasRepositorio")
	private PreguntasRepositorio preguntasRepositorio;

	@Override
	public List<Preguntas> findAll() {
		return preguntasRepositorio.findAll();
	}

	@Override
	public Preguntas findById(Integer backId) {
		return preguntasRepositorio.findById(backId).get();
	}

	@Override
	public void save(Preguntas back) {
		preguntasRepositorio.save(back);
	}

	@Override
	public void delete(Preguntas back) {
		preguntasRepositorio.delete(back);
	}
}

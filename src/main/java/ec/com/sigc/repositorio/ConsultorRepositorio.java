package ec.com.sigc.repositorio;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.sigc.entidad.Consultor;
import ec.com.sigc.entidad.Usuario;

@Repository("consultorRepositorio")
public interface ConsultorRepositorio extends JpaRepository<Consultor, Serializable>{
	public abstract Consultor findAllByUserId(Usuario usu);
}

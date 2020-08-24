package ec.com.sigc.repositorio;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.sigc.entidad.BackOffice;
import ec.com.sigc.entidad.Usuario;

@Repository("backOfficeRepositorio")
public interface BackOfficeRepositorio extends JpaRepository<BackOffice, Serializable>{
	public abstract BackOffice findByUserId(Usuario usu);
}

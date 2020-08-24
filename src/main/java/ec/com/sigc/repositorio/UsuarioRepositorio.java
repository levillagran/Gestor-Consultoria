package ec.com.sigc.repositorio;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.sigc.entidad.RoleSys;
import ec.com.sigc.entidad.Usuario;

@Repository("usuarioRepositorio")
public interface UsuarioRepositorio extends JpaRepository<Usuario, Serializable>{
	public abstract Usuario findByUsuarioAndClave(String usuario, String clave);
	public abstract List<Usuario> findAllByRoleId(RoleSys roleId);
}

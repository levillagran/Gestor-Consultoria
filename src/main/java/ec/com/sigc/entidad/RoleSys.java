package ec.com.sigc.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role_sys")
public class RoleSys implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Size(max = 45)
	@Column(name = "ROL")
	private String rol;
	
	@OneToMany(mappedBy = "roleId")
    private List<Usuario> userList;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	
	public List<Usuario> getUserList() {
		return userList;
	}

	public void setUserList(List<Usuario> userList) {
		this.userList = userList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public RoleSys(Integer roleId, String rol, List<Usuario> userList) {
		super();
		this.roleId = roleId;
		this.rol = rol;
		this.userList = userList;
	}

	public RoleSys() {

	}

	@Override
	public String toString() {
		return "RoleSys [roleId=" + roleId + ", rol=" + rol + ", userList=" + userList + "]";
	}

	public RoleSys(Integer roleId, String rol) {
		super();
		this.roleId = roleId;
		this.rol = rol;
	}

	


}

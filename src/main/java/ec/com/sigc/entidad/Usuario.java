/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sigc.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import ec.com.sigc.entidad.RoleSys;

@Entity
@Table(name = "user")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private Integer userId;

	@Size(max = 50)
	@Column(name = "NOMBRE")
	private String nombre;

	@Size(max = 50)
	@Column(name = "APELLIDO")
	private String apellido;

	@Size(max = 30)
	@Column(name = "MAIL")
	private String mail;

	@Column(name = "TELEFONO")
	private Long telefono;

	@Size(max = 20)
	@Column(name = "USUARIO")
	private String usuario;

	@Size(max = 60)
	@Column(name = "CLAVE")
	private String clave;

	@Size(max = 60)
	@Column(name = "DIRECCION")
	private String direccion;

	@OneToMany(mappedBy = "userId")
	private List<Consultor> auditorList;
	@OneToMany(mappedBy = "userId")
	private List<BackOffice> backOfficeList;
	@OneToMany(mappedBy = "userId")
	private List<Cliente> clienteList;

	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
	@ManyToOne
	@JsonIgnore
	private RoleSys roleId;

	// habilita ingreso
	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	public Usuario() {

	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Consultor> getAuditorList() {
		return auditorList;
	}

	public void setAuditorList(List<Consultor> auditorList) {
		this.auditorList = auditorList;
	}

	public List<BackOffice> getBackOfficeList() {
		return backOfficeList;
	}

	public void setBackOfficeList(List<BackOffice> backOfficeList) {
		this.backOfficeList = backOfficeList;
	}

	public List<Cliente> getClienteList() {
		return clienteList;
	}

	public void setClienteList(List<Cliente> clienteList) {
		this.clienteList = clienteList;
	}

	public RoleSys getRoleId() {
		return roleId;
	}

	public void setRoleId(RoleSys roleId) {
		this.roleId = roleId;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Usuario(Integer userId, @Size(max = 50) String nombre, @Size(max = 50) String apellido,
			@Size(max = 30) String mail, Long telefono, @Size(max = 20) String usuario, @Size(max = 60) String clave,
			@Size(max = 60) String direccion, List<Consultor> auditorList, List<BackOffice> backOfficeList,
			List<Cliente> clienteList, RoleSys roleId, boolean enabled) {
		super();
		this.userId = userId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		this.usuario = usuario;
		this.clave = clave;
		this.direccion = direccion;
		this.auditorList = auditorList;
		this.backOfficeList = backOfficeList;
		this.clienteList = clienteList;
		this.roleId = roleId;
		this.enabled = enabled;
	}

	public Usuario(Integer userId, String nombre, String apellido, String mail, Long telefono, String usuario,
			String clave, String direccion, RoleSys roleId, boolean enabled) {
		super();
		this.userId = userId;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.telefono = telefono;
		this.usuario = usuario;
		this.clave = clave;
		this.direccion = direccion;
		this.roleId = roleId;
		this.enabled = enabled;
	}

}

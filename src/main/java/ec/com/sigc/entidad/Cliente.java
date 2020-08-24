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


@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CLIENTE_ID")
    private Integer clienteId;
    
    @Size(max = 13)
    @Column(name = "RUC")
    private String ruc;
    
    @Size(max = 30)
    @Column(name = "NOMBRE_EMPRESA")
    private String nombreEmpresa;
        
    @OneToMany(mappedBy = "clienteId")
    private List<Informe> informeList;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private Usuario userId;
	
    public Integer getClienteId() {
		return clienteId;
	}
    
	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}
	
	public String getRuc() {
		return ruc;
	}
	
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public List<Informe> getInformeList() {
		return informeList;
	}
	
	public void setInformeList(List<Informe> informeList) {
		this.informeList = informeList;
	}
	
	public Usuario getUserId() {
		return userId;
	}
	
	public void setUserId(Usuario userId) {
		this.userId = userId;
	}
	
	public Cliente(Integer clienteId, String ruc, String nombreEmpresa,
			List<Informe> informeList, Usuario userId) {
		super();
		this.clienteId = clienteId;
		this.ruc = ruc;
		this.nombreEmpresa = nombreEmpresa;
		this.informeList = informeList;
		this.userId = userId;
	}
	
	public Cliente(@NotNull Integer clienteId, @Size(max = 13) String ruc, @Size(max = 30) String nombreEmpresa,
			Usuario userId) {
		super();
		this.clienteId = clienteId;
		this.ruc = ruc;
		this.nombreEmpresa = nombreEmpresa;
		this.userId = userId;
	}

	public Cliente() {
		
	}
    
}

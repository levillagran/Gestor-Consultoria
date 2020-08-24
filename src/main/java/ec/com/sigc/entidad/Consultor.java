/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.sigc.entidad;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.CascadeType;
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

@Entity
@Table(name = "consultor")
public class Consultor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "CONSULTOR_ID")
    private Integer consultorId;
    
    @Column(name = "IMEI")
    private BigInteger imei;
        
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne
    private Usuario userId;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "consultorId")
    private List<Informe> informeList;
    
	public Consultor() {
		
	}

	public Integer getConsultorId() {
		return consultorId;
	}

	public void setConsultorId(Integer consultorId) {
		this.consultorId = consultorId;
	}

	public BigInteger getImei() {
		return imei;
	}

	public void setImei(BigInteger imei) {
		this.imei = imei;
	}

	public Usuario getUserId() {
		return userId;
	}

	public void setUserId(Usuario userId) {
		this.userId = userId;
	}

	public List<Informe> getInformeList() {
		return informeList;
	}

	public void setInformeList(List<Informe> informeList) {
		this.informeList = informeList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Consultor(@NotNull Integer consultorId, BigInteger imei, Usuario userId, List<Informe> informeList) {
		super();
		this.consultorId = consultorId;
		this.imei = imei;
		this.userId = userId;
		this.informeList = informeList;
	}

	public Consultor(Integer consultorId, BigInteger imei, Usuario userId) {
		super();
		this.consultorId = consultorId;
		this.imei = imei;
		this.userId = userId;
	}

    
    
}

package ec.com.sigc.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "entregable")
public class Entregable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ENTREGABLE_ID")
    private Integer entregableId;
    @Lob
    @Column(name = "CERTIFICADO")
    private byte[] certificado;
    @Lob
    @Column(name = "INFORME")
    private byte[] informe;
    
	public Integer getEntregableId() {
		return entregableId;
	}

	public void setEntregableId(Integer entregableId) {
		this.entregableId = entregableId;
	}

	public byte[] getCertificado() {
		return certificado;
	}

	public void setCertificado(byte[] certificado) {
		this.certificado = certificado;
	}

	public byte[] getInforme() {
		return informe;
	}

	public void setInforme(byte[] informe) {
		this.informe = informe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Entregable(Integer entregableId, byte[] certificado, byte[] informe) {
		super();
		this.entregableId = entregableId;
		this.certificado = certificado;
		this.informe = informe;
	}

	public Entregable() {
    }

    
    
}

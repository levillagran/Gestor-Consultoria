package ec.com.sigc.entidad;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "solicitud_consultoria")
public class SolicitudConsultoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SOLICITUD_CONSULTORIA_ID")
    private Integer solicitudConsultoriaId;
    
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Column(name = "FECHA_FINAL")
    @Temporal(TemporalType.DATE)
    private Date fechaFinal;
    
    @JoinColumn(name = "ESTADO_CONSULTORIA_ID", referencedColumnName = "ESTADO_CONSULTORIA_ID")
    @ManyToOne
    private EstadoConsultoria estadoConsultoriaId;
    @JoinColumn(name = "TIPO_CONSULTORIA_ID", referencedColumnName = "TIPO_CONSULTORIA_ID")
    @ManyToOne
    private TipoConsultoria tipoConsultoriaId;
    
    @OneToMany(mappedBy = "solicitudConsultoriaId")
    private List<CheckList> checkListList;
   
    @OneToMany(mappedBy = "solicitudConsultoriaId")
    private List<DatoComun> datoComunList;
   
	public Integer getSolicitudConsultoriaId() {
		return solicitudConsultoriaId;
	}

	public void setSolicitudConsultoriaId(Integer solicitudConsultoriaId) {
		this.solicitudConsultoriaId = solicitudConsultoriaId;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public EstadoConsultoria getEstadoConsultoriaId() {
		return estadoConsultoriaId;
	}

	public void setEstadoConsultoriaId(EstadoConsultoria estadoConsultoriaId) {
		this.estadoConsultoriaId = estadoConsultoriaId;
	}

	public TipoConsultoria getTipoConsultoriaId() {
		return tipoConsultoriaId;
	}

	public void setTipoConsultoriaId(TipoConsultoria tipoConsultoriaId) {
		this.tipoConsultoriaId = tipoConsultoriaId;
	}

	public List<CheckList> getCheckListList() {
		return checkListList;
	}

	public void setCheckListList(List<CheckList> checkListList) {
		this.checkListList = checkListList;
	}

	public List<DatoComun> getDatoComunList() {
		return datoComunList;
	}

	public void setDatoComunList(List<DatoComun> datoComunList) {
		this.datoComunList = datoComunList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public SolicitudConsultoria(@NotNull Integer solicitudConsultoriaId, Date fechaInicio, Date fechaFinal,
			EstadoConsultoria estadoConsultoriaId, TipoConsultoria tipoConsultoriaId, List<CheckList> checkListList,
			List<DatoComun> datoComunList) {
		super();
		this.solicitudConsultoriaId = solicitudConsultoriaId;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.estadoConsultoriaId = estadoConsultoriaId;
		this.tipoConsultoriaId = tipoConsultoriaId;
		this.checkListList = checkListList;
		this.datoComunList = datoComunList;
	}

	public SolicitudConsultoria() {
    }

    
    
}

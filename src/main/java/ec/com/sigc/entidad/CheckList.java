package ec.com.sigc.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "check_list")
public class CheckList implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "CHECK_LIST_ID")
	private Integer checkListId;

	@JoinColumn(name = "PREGUNTAS_ID", referencedColumnName = "PREGUNTAS_ID")
	@ManyToOne
	private Preguntas preguntasId;

	@Column(name = "CODIGO")
	private Integer codigo;

	@JoinColumn(name = "DATO_ESPECIFICO_ID", referencedColumnName = "DATO_ESPECIFICO_ID")
	@ManyToOne
	private DatoEspecifico datoEspecificoId;

	@JoinColumn(name = "SOLICITUD_CONSULTORIA_ID", referencedColumnName = "SOLICITUD_CONSULTORIA_ID")
	@ManyToOne
	private SolicitudConsultoria solicitudConsultoriaId;

	public Integer getCheckListId() {
		return checkListId;
	}

	public void setCheckListId(Integer checkListId) {
		this.checkListId = checkListId;
	}

	public Preguntas getPreguntasId() {
		return preguntasId;
	}

	public void setPreguntasId(Preguntas preguntasId) {
		this.preguntasId = preguntasId;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public DatoEspecifico getDatoEspecificoId() {
		return datoEspecificoId;
	}

	public void setDatoEspecificoId(DatoEspecifico datoEspecificoId) {
		this.datoEspecificoId = datoEspecificoId;
	}

	public SolicitudConsultoria getSolicitudConsultoriaId() {
		return solicitudConsultoriaId;
	}

	public void setSolicitudConsultoriaId(SolicitudConsultoria solicitudConsultoriaId) {
		this.solicitudConsultoriaId = solicitudConsultoriaId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CheckList() {

	}

	public CheckList(@NotNull Integer checkListId, Preguntas preguntasId, Integer codigo,
			DatoEspecifico datoEspecificoId, SolicitudConsultoria solicitudConsultoriaId) {
		super();
		this.checkListId = checkListId;
		this.preguntasId = preguntasId;
		this.codigo = codigo;
		this.datoEspecificoId = datoEspecificoId;
		this.solicitudConsultoriaId = solicitudConsultoriaId;
	}

}

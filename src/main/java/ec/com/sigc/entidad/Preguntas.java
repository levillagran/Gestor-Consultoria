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

@Entity
@Table(name = "preguntas")
public class Preguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "PREGUNTAS_ID")
    private Integer preguntasId;
    
    @Column(name = "PREGUNTAS")
    private String preguntas;
    
    @Column(name = "ACTIVIDAD")
    private String actividad;
    
    @Column(name = "ENTREGABLE")
    private String entregable;
    
    @OneToMany(mappedBy = "preguntasId")
    private List<CheckList> checkListList;
    
    @JoinColumn(name = "SECCION_ID", referencedColumnName = "SECCION_ID")
    @ManyToOne
    private Seccion seccionId;
    
    @JoinColumn(name = "TIPO_CONSULTORIA_ID", referencedColumnName = "TIPO_CONSULTORIA_ID")
    @ManyToOne
    private TipoConsultoria tipoConsultoriaId;

   	public Integer getPreguntasId() {
		return preguntasId;
	}

	public void setPreguntasId(Integer preguntasId) {
		this.preguntasId = preguntasId;
	}

	public String getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(String preguntas) {
		this.preguntas = preguntas;
	}

	public List<CheckList> getCheckListList() {
		return checkListList;
	}

	public void setCheckListList(List<CheckList> checkListList) {
		this.checkListList = checkListList;
	}

	public Seccion getSeccionId() {
		return seccionId;
	}

	public void setSeccionId(Seccion seccionId) {
		this.seccionId = seccionId;
	}

	public TipoConsultoria getTipoConsultoriaId() {
		return tipoConsultoriaId;
	}

	public void setTipoConsultoriaId(TipoConsultoria tipoConsultoriaId) {
		this.tipoConsultoriaId = tipoConsultoriaId;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getEntregable() {
		return entregable;
	}

	public void setEntregable(String entregable) {
		this.entregable = entregable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Preguntas(@NotNull Integer preguntasId, String preguntas, String actividad, String entregable,
			List<CheckList> checkListList, Seccion seccionId, TipoConsultoria tipoConsultoriaId) {
		super();
		this.preguntasId = preguntasId;
		this.preguntas = preguntas;
		this.actividad = actividad;
		this.entregable = entregable;
		this.checkListList = checkListList;
		this.seccionId = seccionId;
		this.tipoConsultoriaId = tipoConsultoriaId;
	}

	public Preguntas(@NotNull Integer preguntasId, String preguntas, String actividad, String entregable,
			Seccion seccionId, TipoConsultoria tipoConsultoriaId) {
		super();
		this.preguntasId = preguntasId;
		this.preguntas = preguntas;
		this.actividad = actividad;
		this.entregable = entregable;
		this.seccionId = seccionId;
		this.tipoConsultoriaId = tipoConsultoriaId;
	}

	public Preguntas() {
    }

    
    
}

package ec.com.sigc.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tipo_consultoria")
public class TipoConsultoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "TIPO_CONSULTORIA_ID")
    private Integer tipoConsultoriaId;
    
    @Size(max = 40)
    @Column(name = "TIPO_CONSULTORIA")
    private String tipoConsultoria;
    
    @OneToMany(mappedBy = "tipoConsultoriaId", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<SolicitudConsultoria> solicitudConsultoriaList;
    
    @OneToMany(mappedBy = "tipoConsultoriaId")
    @JsonIgnore
    private List<Preguntas> preguntasList;

	public TipoConsultoria() {
    }

	public Integer getTipoConsultoriaId() {
		return tipoConsultoriaId;
	}

	public void setTipoConsultoriaId(Integer tipoConsultoriaId) {
		this.tipoConsultoriaId = tipoConsultoriaId;
	}

	public String getTipoConsultoria() {
		return tipoConsultoria;
	}

	public void setTipoConsultoria(String tipoConsultoria) {
		this.tipoConsultoria = tipoConsultoria;
	}

	public List<SolicitudConsultoria> getSolicitudConsultoriaList() {
		return solicitudConsultoriaList;
	}

	public void setSolicitudConsultoriaList(List<SolicitudConsultoria> solicitudConsultoriaList) {
		this.solicitudConsultoriaList = solicitudConsultoriaList;
	}

	public List<Preguntas> getPreguntasList() {
		return preguntasList;
	}

	public void setPreguntasList(List<Preguntas> preguntasList) {
		this.preguntasList = preguntasList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TipoConsultoria(@NotNull Integer tipoConsultoriaId, @Size(max = 40) String tipoConsultoria,
			List<SolicitudConsultoria> solicitudConsultoriaList, List<Preguntas> preguntasList) {
		super();
		this.tipoConsultoriaId = tipoConsultoriaId;
		this.tipoConsultoria = tipoConsultoria;
		this.solicitudConsultoriaList = solicitudConsultoriaList;
		this.preguntasList = preguntasList;
	}

	public TipoConsultoria(@NotNull Integer tipoConsultoriaId, @Size(max = 40) String tipoConsultoria) {
		super();
		this.tipoConsultoriaId = tipoConsultoriaId;
		this.tipoConsultoria = tipoConsultoria;
	}

    
}

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
@Table(name = "seccion")
public class Seccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "SECCION_ID")
    private Integer seccionId;
    
    @Size(max = 45)
    @Column(name = "SECCION")
    private String seccion;
    
    @OneToMany(mappedBy = "seccionId", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Preguntas> preguntasList;
    

    public Integer getSeccionId() {
		return seccionId;
	}

	public void setSeccionId(Integer seccionId) {
		this.seccionId = seccionId;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
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
	
	public Seccion(Integer seccionId, String seccion, List<Preguntas> preguntasList) {
		super();
		this.seccionId = seccionId;
		this.seccion = seccion;
		this.preguntasList = preguntasList;
	}

	public Seccion(@NotNull Integer seccionId, @Size(max = 45) String seccion) {
		super();
		this.seccionId = seccionId;
		this.seccion = seccion;
	}

	public Seccion() {
    }

    
    
}

package ec.com.sigc.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "dato_especifico")
public class DatoEspecifico implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "DATO_ESPECIFICO_ID")
	private Integer datoEspecificoId;

	@Column(name = "RESPUESTA")
	private boolean respuesta;

	@Column(name = "ACTIVIDAD")
	private String actividad;
	
	@Column(name = "ENTREGABLE")
	private String entregable;

	@OneToMany(mappedBy = "datoEspecificoId")
	private List<CheckList> checkListList;

	@JoinColumn(name = "ARCHIVO_ID", referencedColumnName = "ARCHIVO_ID")
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Archivo archivoId;

		public DatoEspecifico() {
	}

		public Integer getDatoEspecificoId() {
			return datoEspecificoId;
		}

		public void setDatoEspecificoId(Integer datoEspecificoId) {
			this.datoEspecificoId = datoEspecificoId;
		}

		public boolean isRespuesta() {
			return respuesta;
		}

		public void setRespuesta(boolean respuesta) {
			this.respuesta = respuesta;
		}

		public List<CheckList> getCheckListList() {
			return checkListList;
		}

		public void setCheckListList(List<CheckList> checkListList) {
			this.checkListList = checkListList;
		}

		public Archivo getArchivoId() {
			return archivoId;
		}

		public void setArchivoId(Archivo archivoId) {
			this.archivoId = archivoId;
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

		public DatoEspecifico(@NotNull Integer datoEspecificoId, boolean respuesta, String actividad, String entregable,
				List<CheckList> checkListList, Archivo archivoId) {
			super();
			this.datoEspecificoId = datoEspecificoId;
			this.respuesta = respuesta;
			this.actividad = actividad;
			this.entregable = entregable;
			this.checkListList = checkListList;
			this.archivoId = archivoId;
		}

}

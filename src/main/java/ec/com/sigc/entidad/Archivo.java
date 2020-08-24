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
@Table(name = "archivo")
public class Archivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ARCHIVO_ID")
    private Integer archivoId;
    
    @Column(name = "NOMBRE_ARCHIVO")
    private String fileName;
    
    @Column(name = "TIPO_ARCHIVO")
    private String fileType;
    
    @Lob
    @Column(name = "ARCHIVO")
    private byte[] archivo;

	public Integer getArchivoId() {
		return archivoId;
	}

	public void setArchivoId(Integer archivoId) {
		this.archivoId = archivoId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Archivo() {
    }

	public Archivo(@NotNull Integer archivoId, String fileName, String fileType, byte[] archivo) {
		super();
		this.archivoId = archivoId;
		this.fileName = fileName;
		this.fileType = fileType;
		this.archivo = archivo;
	}
    
}

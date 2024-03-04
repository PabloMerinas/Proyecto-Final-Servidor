package app.backendServidor.persistence.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "T_PERSON")
public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_IDPERSON")
	private Long idPerson;

	@Column(name = "C_NAME")
	private String name;

	@Column(name = "C_SUBNAME")
	private String subname;

	@OneToOne()
	@JoinColumn(name = "C_IDUSER", referencedColumnName = "C_IDUSER")
	@JsonBackReference
	private User user;
}

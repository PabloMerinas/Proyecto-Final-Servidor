package app.backendServidor.persistence.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "T_USER")
public class User implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "C_IDUSER")
	private Long idUser;

	@Column(name = "C_NAME")
	private String name;

	@Column(name = "C_USERNAME")
	private String username;

	@Column(name = "C_PASSWORD")
	private String password;

	@Column(name = "C_MAIL")
	private String mail;

//	@OneToOne(mappedBy = "user")
//	@JsonManagedReference
//	private Person person;

}

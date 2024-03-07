package app.backendServidor.security;

import lombok.Data;

@Data
public class AuthCredentials {
	private String mail;
	private String password;
}

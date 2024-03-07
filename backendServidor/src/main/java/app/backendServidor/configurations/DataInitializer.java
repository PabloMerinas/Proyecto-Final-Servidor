package app.backendServidor.configurations;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

	private final JdbcTemplate jdbcTemplate;

	public DataInitializer(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	public void initializeData() {
		String password = new BCryptPasswordEncoder().encode("prueba");
		System.out.println("Usuario de prueba\nMail: prueba@prueba.com\nContraseña: prueba");

		executeSqlStatement(
				"INSERT INTO T_USER (C_USERNAME, C_PASSWORD, C_MAIL) VALUES ('user1', '" + password + "', 'prueba@prueba.com');");
		executeSqlStatement(
				"INSERT INTO T_PERSON (C_NAME, C_SUBNAME) VALUES ('John', 'Doe');");
	} // INSERT INTO T_PERSON (C_NAME, C_SUBNAME, C_IDUSER) VALUES ('John', 'Doe', '1');"

	private void executeSqlStatement(String sqlStatement) {
		jdbcTemplate.execute(sqlStatement);
	}
}

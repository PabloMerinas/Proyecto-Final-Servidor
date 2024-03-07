package app.backendServidor.configuration;

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
		String password = new BCryptPasswordEncoder().encode("admin");

		executeSqlStatement(
				"INSERT INTO T_USER (C_USERNAME, C_NAME, C_PASSWORD, C_MAIL) VALUES ('user1','Pablo Administrador', '"
						+ password + "', 'admin@admin.com');");
		executeSqlStatement("INSERT INTO T_PERSON (C_NAME, C_SUBNAME) VALUES ('Pablo', 'Merinas');");
	}

	private void executeSqlStatement(String sqlStatement) {
		jdbcTemplate.execute(sqlStatement);
	}
}

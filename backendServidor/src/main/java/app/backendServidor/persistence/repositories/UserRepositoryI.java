package app.backendServidor.persistence.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.backendServidor.persistence.model.User;

@Repository
public interface UserRepositoryI extends JpaRepository<User, Long> {

	Optional<User> findOneByMail(String mail);

}

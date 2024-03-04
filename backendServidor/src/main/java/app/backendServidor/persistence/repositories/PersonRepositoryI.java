package app.backendServidor.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.backendServidor.persistence.model.Person;

@Repository
public interface PersonRepositoryI extends JpaRepository<Person, Long> {

}

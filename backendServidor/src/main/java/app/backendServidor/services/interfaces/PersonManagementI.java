package app.backendServidor.services.interfaces;

import java.util.List;
import java.util.Optional;

import app.backendServidor.persistence.model.Person;

public interface PersonManagementI {

	List<Person> findAllPersons();

	Person findById(Long id);

	Optional<Person> findPersonById(Long id);

	Person savePerson(Person person);

	void deletePerson(Long id);

}

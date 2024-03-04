package app.backendServidor.services.interfaces;

import java.util.List;

import app.backendServidor.persistence.model.Person;

public interface PersonManagementI {

	List<Person> findAllPersons();

	Person findById(Long id);

}

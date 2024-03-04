package app.backendServidor.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import app.backendServidor.persistence.model.Person;
import app.backendServidor.persistence.repositories.PersonRepositoryI;
import app.backendServidor.services.interfaces.PersonManagementI;

@Service
public class PersonManagementImpl implements PersonManagementI {

	private PersonRepositoryI personRepositoryI;

	public PersonManagementImpl(PersonRepositoryI personRepositoryI) {
		this.personRepositoryI = personRepositoryI;
	}

	@Override
	public List<Person> findAllPersons() {
		return personRepositoryI.findAll();
	}

	@Override
	public Person findById(Long id) {
		return personRepositoryI.findById(id).orElse(null);
	}

}

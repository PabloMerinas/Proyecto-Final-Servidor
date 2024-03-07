package app.backendServidor.services.implement;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Optional<Person> findPersonById(Long id) {
		return personRepositoryI.findById(id);
	}

	@Override
	public Person savePerson(Person person) {
		personRepositoryI.save(person);
		return person;
	}

	@Override
	public void deletePerson(Long id) {
		personRepositoryI.deleteById(id);
	}

}

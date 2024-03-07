package app.backendServidor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import app.backendServidor.controller.PersonRestController;
import app.backendServidor.persistence.model.Person;
import app.backendServidor.services.interfaces.PersonManagementI;

class PersonRestControllerTest {

	private PersonRestController personController;
	private PersonManagementI personService;

	@BeforeEach
	public void setUp() {
		personService = mock(PersonManagementI.class);
		personController = new PersonRestController(personService);
	}

	@Test
	void testGetPersons() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person());
		when(personService.findAllPersons()).thenReturn(personList);

		ResponseEntity<Object> response = personController.getPersons();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(personList);
	}

	@Test
	void testGetPersonById() {
		Long personId = 1L;
		Person person = new Person();
		person.setIdPerson(personId);
		when(personService.findPersonById(personId)).thenReturn(Optional.of(person));

		ResponseEntity<Object> response = personController.getPersonById(personId);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(person);
	}

	@Test
	void testAddPerson() {
		Person newPerson = new Person();
		newPerson.setIdPerson(1L);
		when(personService.savePerson(newPerson)).thenReturn(newPerson);

		ResponseEntity<Object> response = personController.addPerson(newPerson);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isEqualTo("Persona añadida correctamente\n" + newPerson);
	}

	@Test
	void testUpdatePerson() {
		Long personId = 1L;
		Person personToUpdate = new Person();
		personToUpdate.setIdPerson(personId);
		when(personService.findPersonById(personId)).thenReturn(Optional.of(personToUpdate));
		when(personService.savePerson(personToUpdate)).thenReturn(personToUpdate);

		ResponseEntity<Object> response = personController.updatePerson(personId, personToUpdate);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(personToUpdate);
	}

	@Test
	void testDeletePerson() {
		Long personId = 1L;
		Person personToDelete = new Person();
		personToDelete.setIdPerson(personId);
		when(personService.findPersonById(personId)).thenReturn(Optional.of(personToDelete));

		ResponseEntity<Object> response = personController.deletePerson(personId);

		verify(personService, times(1)).deletePerson(personId);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("Persona eliminada correctamente");
	}
}
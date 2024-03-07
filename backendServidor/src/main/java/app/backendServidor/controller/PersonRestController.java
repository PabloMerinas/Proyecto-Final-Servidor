package app.backendServidor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import app.backendServidor.persistence.model.Person;
import app.backendServidor.services.interfaces.PersonManagementI;

@Controller
@RequestMapping("/v1/person")
public class PersonRestController {

	private static String PERSONNOTFOUNDMSG = "Persona no encontrada";

	private PersonManagementI personManagementI;

	public PersonRestController(PersonManagementI personManagementI) {
		this.personManagementI = personManagementI;
	}

	// Endpoint para obtener todas las personas
	@GetMapping
	public ResponseEntity<Object> getPersons() {
		try {
			List<Person> persons = personManagementI.findAllPersons();
			return ResponseEntity.ok(persons);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al obtener personas: " + e.getMessage());
		}
	}

	// Endpoint para obtener una persona por su ID
	@GetMapping("/{id}")
	public ResponseEntity<Object> getPersonById(@PathVariable Long id) {
		try {
			Optional<Person> person = personManagementI.findPersonById(id);
			if (person.isPresent()) {
				return ResponseEntity.ok(person.get());
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(PERSONNOTFOUNDMSG);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al obtener persona: " + e.getMessage());
		}
	}

	// Endpoint para agregar una nueva persona
	@PostMapping
	public ResponseEntity<Object> addPerson(@RequestBody Person person) {
		try {
			Person newPerson = personManagementI.savePerson(person);
			return ResponseEntity.status(HttpStatus.CREATED).body("Persona añadida correctamente\n" + newPerson);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al agregar persona: " + e.getMessage());
		}
	}

	// Endpoint para actualizar una persona existente
	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePerson(@PathVariable Long id, @RequestBody Person person) {
		try {
			Optional<Person> existingPerson = personManagementI.findPersonById(id);
			if (existingPerson.isPresent()) {
				person.setIdPerson(id);
				Person updatedPerson = personManagementI.savePerson(person);
				return ResponseEntity.ok(updatedPerson);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(PERSONNOTFOUNDMSG);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al actualizar persona: " + e.getMessage());
		}
	}

	// Endpoint para eliminar una persona por su ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePerson(@PathVariable Long id) {
		try {
			Optional<Person> person = personManagementI.findPersonById(id);
			if (person.isPresent()) {
				personManagementI.deletePerson(id);
				return ResponseEntity.ok("Persona eliminada correctamente");
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(PERSONNOTFOUNDMSG);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al eliminar persona: " + e.getMessage());
		}
	}
}

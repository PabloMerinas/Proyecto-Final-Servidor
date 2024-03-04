package app.backendServidor.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.backendServidor.persistence.model.Person;
import app.backendServidor.services.interfaces.PersonManagementI;

@Controller
@RequestMapping("/v1/person")
public class PersonRestController {

	private PersonManagementI personManagementI;

	public PersonRestController(PersonManagementI personManagementI) {
		this.personManagementI = personManagementI;
	}

	@GetMapping
	public ResponseEntity<Object> getPersons() {
		List<Person> persons = personManagementI.findAllPersons();
		if (persons != null) {
			return ResponseEntity.ok(persons);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}

	}

	@GetMapping("/findById")
	public ResponseEntity<Object> getPersonById(@RequestParam Long id) {
		Person p = personManagementI.findById(id);
		if (p != null) {
			return ResponseEntity.ok(p);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
		}
	}
}

package app.backendServidor.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import app.backendServidor.persistence.model.User;
import app.backendServidor.services.interfaces.UserManagementI;

@Controller
@RequestMapping("/v1/user")
public class UserRestController {

	private UserManagementI userManagementI;

	public UserRestController(UserManagementI userManagementI) {
		this.userManagementI = userManagementI;
	}

	@GetMapping
	public ResponseEntity<Object> getUsers() {
		List<User> users = userManagementI.findAllUsers();
		if (users != null) {
			return ResponseEntity.ok(users);
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(("Error"));
		}
	}

	@PostMapping
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		return null;
	}

}

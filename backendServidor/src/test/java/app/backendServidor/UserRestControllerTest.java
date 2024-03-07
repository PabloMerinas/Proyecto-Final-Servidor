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

import app.backendServidor.controller.UserRestController;
import app.backendServidor.persistence.model.User;
import app.backendServidor.services.interfaces.UserManagementI;

class UserRestControllerTest {

	private UserRestController userController;
	private UserManagementI userService;

	@BeforeEach
	public void setUp() {
		userService = mock(UserManagementI.class);
		userController = new UserRestController(userService);
	}

	@Test
	public void testGetUsers() {
		List<User> userList = new ArrayList<>();
		userList.add(new User());
		when(userService.findAllUsers()).thenReturn(userList);

		ResponseEntity<Object> response = userController.getUsers();

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(userList);
	}

	@Test
	public void testGetUserById() {
		Long userId = 1L;
		User user = new User();
		user.setIdUser(userId);
		when(userService.findUserById(userId)).thenReturn(Optional.of(user));

		ResponseEntity<Object> response = userController.getUserById(userId);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(user);
	}

	@Test
	public void testAddUser() {
		User newUser = new User();
		newUser.setIdUser(1L);
		when(userService.addUser(newUser)).thenReturn(newUser);

		ResponseEntity<Object> response = userController.addUser(newUser);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getBody()).isEqualTo("Usuario añadido correctamente\n" + newUser);
	}

	@Test
	public void testUpdateUser() {
		Long userId = 1L;
		User userToUpdate = new User();
		userToUpdate.setIdUser(userId);
		when(userService.findUserById(userId)).thenReturn(Optional.of(userToUpdate));
		when(userService.addUser(userToUpdate)).thenReturn(userToUpdate);

		ResponseEntity<Object> response = userController.updateUser(userId, userToUpdate);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(userToUpdate);
	}

	@Test
	public void testDeleteUser() {
		Long userId = 1L;
		User userToDelete = new User();
		userToDelete.setIdUser(userId);
		when(userService.findUserById(userId)).thenReturn(Optional.of(userToDelete));

		ResponseEntity<Object> response = userController.deleteUser(userId);

		verify(userService, times(1)).deleteUser(userId);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo("Usuario eliminado correctamente");
	}

}

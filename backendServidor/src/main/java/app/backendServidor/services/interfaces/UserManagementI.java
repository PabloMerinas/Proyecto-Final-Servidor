package app.backendServidor.services.interfaces;

import java.util.List;
import java.util.Optional;

import app.backendServidor.persistence.model.User;

public interface UserManagementI {

	public void addUser(User u);

	public List<User> findAllUsers();

}

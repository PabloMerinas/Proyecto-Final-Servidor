package app.backendServidor.services.interfaces;

import java.util.List;

import app.backendServidor.persistence.model.User;

public interface UserManagementI {

	public void addUser(User u);

	public List<User> findAllUsers();
}

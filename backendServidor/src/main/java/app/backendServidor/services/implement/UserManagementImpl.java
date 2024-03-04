package app.backendServidor.services.implement;

import java.util.List;

import org.springframework.stereotype.Service;

import app.backendServidor.persistence.model.User;
import app.backendServidor.persistence.repositories.UserRepositoryI;
import app.backendServidor.services.interfaces.UserManagementI;

@Service
public class UserManagementImpl implements UserManagementI {

	private UserRepositoryI userRepositoryI;

	public UserManagementImpl(UserRepositoryI userRepositoryI) {
		this.userRepositoryI = userRepositoryI;
	}

	@Override
	public void addUser(User u) {
		userRepositoryI.save(u);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepositoryI.findAll();
	}

}

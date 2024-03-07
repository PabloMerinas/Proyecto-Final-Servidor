package app.backendServidor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.backendServidor.persistence.model.User;
import app.backendServidor.persistence.repositories.UserRepositoryI;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepositoryI userRepository;

	@Override
	public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
		User user = userRepository.findOneByMail(mail)
				.orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + mail + " no existe."));

		return new UserDetailsImpl(user);
	}

}

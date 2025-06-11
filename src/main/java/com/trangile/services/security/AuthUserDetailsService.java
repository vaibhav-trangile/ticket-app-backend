package com.trangile.services.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trangile.db.repo.users.UserRepository;


//public class AuthUserDetailsService {}

@Service
public class AuthUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<com.trangile.db.entities.users.User> byUserNameOrEmail = repository.findByUserNameOrEmail(username);
		com.trangile.db.entities.users.User orElseThrow = byUserNameOrEmail.orElseThrow(() -> new UsernameNotFoundException("User not found with input: " + username));
		return UserDetailsImpl.build(orElseThrow);
	}

}

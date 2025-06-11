package com.trangile.services.users.impls;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.trangile.db.entities.users.Role;
import com.trangile.db.entities.users.User;
import com.trangile.db.repo.users.RoleRepository;
import com.trangile.db.repo.users.UserRepository;
import com.trangile.services.users.UserService;
import com.trangile.ui.req.dto.LoginDto;
import com.trangile.ui.req.dto.UserDto;
import com.trangile.ui.res.dto.EngineerDto;
import com.trangile.ui.res.dto.UserDtoResponse;
import com.trangile.util.AppConstants;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDtoResponse createUser(UserDto dto) {
		return createUserReturnResponse(dto);
	}
	
	
	private UserDtoResponse createUserReturnResponse(UserDto source) {
		System.out.println(source);
		User toBeSavedUser = getUserEntry(source);
		Set<Role> roles = getRoles(source.getRoles());
		toBeSavedUser.setRoles(roles);
		User savedUser = userRepository.save(toBeSavedUser);
		return getUserDtoResponse(savedUser);
	}	
	
	


	private UserDtoResponse getUserDtoResponse(User savedUser) {
		UserDtoResponse userResponse = new UserDtoResponse();
		BeanUtils.copyProperties(savedUser, userResponse);
		return userResponse;
	}


	private User getUserEntry(UserDto source) {
		User user = new User(source.getUserName(), source.getFullName(), source.getEmail());
		user.setPassword(passwordEncoder.encode(source.getPassword()));
		if (source.getIsActive()) {
			user.setIsActive(true);
		}
		user.setIsEmailVerified(true);
		user.setIsLocked(false);
		user.setCreatedBy(source.getCreatedBy());
		return user;
	}


	private Set<Role> getRoles(List<String> roles) {
		Set<Role> roleSet = new HashSet<>();
		for (String role : roles) {
			Role byName = roleRepository.findByName(AppConstants.ROLE_STRING + role);
			if (byName == null) {
				byName = new Role();
				byName.setName(role);
				byName = roleRepository.save(byName);
            }
			roleSet.add(byName);
		}
		return roleSet;
	}


	@Override
	public UserDtoResponse getUser(String name) {
		Optional<User> byUserNameOrEmail2 = userRepository.findByUserNameOrEmail(name);
//		Optional<User> byUserNameOrEmail2 = userRepository.findByUserName(name);
		if (!byUserNameOrEmail2.isEmpty()) {
			return getUserDtoResponse(byUserNameOrEmail2.get());
		}
		return null;
	}


	@Override
	public String authenticate(LoginDto dto) {
		
		
		
		
		
		
		return null;
	}


	@Override
	public List<EngineerDto> getEngineers() {
		List<User> usersByRole = userRepository.findUsersByRole("ROLE_ENGINEER".toUpperCase());
		List<EngineerDto> engineers = usersByRole.stream().map(u -> {
			EngineerDto dto = new EngineerDto();
			dto.setFullName(u.getFullName());
			dto.setEmail(u.getEmail());
			dto.setIsAssigned(getIsAssigned(u.getFullName()));
			return dto;
		}).collect(Collectors.toList());
		return engineers;
	}


	private Boolean getIsAssigned(String fullName) {
		if (fullName.startsWith("v") || fullName.startsWith("V"))
			return true;
		return false;
	}


	@Override
	public boolean existsByUsername(String username) {
		Optional<User> byUserName = userRepository.findByUserName(username);
		if (byUserName.isEmpty()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean existsByEmail(String email) {
		Optional<User> byUserEmail = userRepository.findByEmail(email);
		if (byUserEmail.isEmpty()) {
			return true;
		}
		return false;
	}


	@Override
	public String deleteUser(String user) {
		Optional<User> byUserName = userRepository.findByUserName(user);
		if (byUserName.isPresent()) {
			User user2 = byUserName.get();
			user2.setIsActive(false);
			userRepository.save(user2);
			return "user deletion completed.";
		}
		return "";
	}
}
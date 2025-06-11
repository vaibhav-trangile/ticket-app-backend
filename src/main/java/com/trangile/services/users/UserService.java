package com.trangile.services.users;

import java.util.List;

import com.trangile.ui.req.dto.LoginDto;
import com.trangile.ui.req.dto.UserDto;
import com.trangile.ui.res.dto.EngineerDto;
import com.trangile.ui.res.dto.UserDtoResponse;

public interface UserService {
	
	UserDtoResponse createUser(UserDto dto);

	UserDtoResponse getUser(String name);

	String authenticate(LoginDto dto);

	List<EngineerDto> getEngineers();

	boolean existsByUsername(String username);
	
	boolean existsByEmail(String email);

	String deleteUser(String valueOf);

}

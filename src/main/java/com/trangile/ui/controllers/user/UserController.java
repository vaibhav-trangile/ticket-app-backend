package com.trangile.ui.controllers.user;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trangile.services.users.UserService;
import com.trangile.ui.res.dto.ApiResponse;
import com.trangile.ui.res.dto.EngineerDto;
import com.trangile.ui.res.dto.UserDtoResponse;
import com.trangile.util.AppConstants;

@RestController
@RequestMapping(AppConstants.BACKEND_BASE_URI + AppConstants.USER_API_URI)
@CrossOrigin(AppConstants.CORS_URI)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value = "/user")
	public ResponseEntity<?> getUser(@RequestParam String name) {
		UserDtoResponse user = userService.getUser(name);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	
//	@GetMapping(value = "/users")
//	public ResponseEntity<?> getAllUser() {
//		UserDtoResponse user = userService.getAllUser();
//		return new ResponseEntity<>(user, HttpStatus.CREATED);
//	}
	
	
	@GetMapping(value = "/engineers")
	public ResponseEntity<ApiResponse<Object>> getEngineers() {
		List<EngineerDto> engineers = userService.getEngineers();
		ApiResponse<Object> api = new ApiResponse<Object>();
		if (engineers != null && engineers.size() > 0) {
			api.setCode(HttpStatus.OK.value());
			api.setTime(LocalDateTime.now());
			api.setSuccess(true);
			api.setMessage("Data received successfully.");
			api.setData(engineers);
			return new ResponseEntity<ApiResponse<Object>>(api, HttpStatus.OK);
		}
		api.setCode(HttpStatus.BAD_REQUEST.value());
		api.setTime(LocalDateTime.now());
		api.setSuccess(false);
		api.setMessage("Some thing went wrong.");
		return new ResponseEntity<>(api, HttpStatus.BAD_REQUEST);
	}
	
	
	
}
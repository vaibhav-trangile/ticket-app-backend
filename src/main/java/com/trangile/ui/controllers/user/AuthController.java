package com.trangile.ui.controllers.user;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trangile.services.users.AuthService;
import com.trangile.services.users.UserService;
import com.trangile.ui.req.dto.LoginDto;
import com.trangile.ui.req.dto.UserDto;
import com.trangile.ui.req.dto.UserFormDto;
import com.trangile.ui.res.dto.ApiResponse;
import com.trangile.ui.res.dto.AuthResponse;
import com.trangile.ui.res.dto.EmailUserCheckDto;
import com.trangile.ui.res.dto.UserDtoResponse;
import com.trangile.util.AppConstants;

@RestController
@RequestMapping(AppConstants.BACKEND_BASE_URI + AppConstants.BACKEND_USER_API_URI)
@CrossOrigin(AppConstants.CORS_URI)
public class AuthController {
	
	@Autowired
	private UserService service;
	
	@Autowired
	private AuthService authService;	
	
	
	@PostMapping(value = "/authenticate")
    public ResponseEntity<ApiResponse<Object>> login(@RequestHeader("Authorization") String authHeader) {
		try {
			if (authHeader == null || !authHeader.startsWith("Basic ")) {
        		ApiResponse<Object> response = new ApiResponse<>(
                        HttpStatus.BAD_REQUEST.value(),
                        false,
                        LocalDateTime.now(),
                        "Missing or invalid Authorization header",
                        null,
                        null
                    );
                return ResponseEntity.badRequest().body(response);
            }
			String base64Credentials = authHeader.substring("Basic ".length());
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            String[] userDetails = credentials.split(":", 2);
            if (userDetails.length != 2) {
            	ApiResponse<Object> response = new ApiResponse<>(
                        HttpStatus.BAD_REQUEST.value(),
                        false,
                        LocalDateTime.now(),
                        "Invalid Authorization format",
                        null,
                        null
                    );
                return ResponseEntity.badRequest().body(response);
            }
            
            LoginDto dto = new LoginDto(userDetails[0], userDetails[1]);

            // Validate the credentials
//            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            if (dto != null) {
                AuthResponse validateAndGenerateToken = authService.validateAndGenerateToken(dto);
                ApiResponse<Object> response = new ApiResponse<Object>(HttpStatus.OK.value(), true, LocalDateTime.now(),"Token generated successfully.", validateAndGenerateToken, null);
                return ResponseEntity.ok().body(response);
            }
            
		} catch (BadCredentialsException ex) {
            ApiResponse<Object> response = new ApiResponse<>(
                    HttpStatus.UNAUTHORIZED.value(),
                    false,
                    LocalDateTime.now(),
                    "Invalid username or password",
                    null,
                    new ApiResponse.ErrorDetails("BAD_CREDENTIALS", ex.getMessage(), null)
                );
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }
		return null;
    }
	
	
	
	
	@PostMapping(value = "/register")
	public ResponseEntity<?> saveUser(@RequestBody UserFormDto userFormDto) {
		UserDto userDto = new UserDto(); 
		userDto.setUserName(userFormDto.getUserName());
		userDto.setFullName(userFormDto.getFirstName() + " " + userFormDto.getLastName());
		userDto.setEmail(userFormDto.getEmail());
		userDto.setPassword(userFormDto.getPassword());
//		userDto.set(userFormDto.getUserName());
		userDto.setIsActive(true);
		if (userFormDto.getRoles() == null) {
			userDto.setRoles(Arrays.asList("USER"));
		} else {
			userDto.setRoles(userFormDto.getRoles());
		}
		UserDtoResponse user = service.createUser(userDto);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/checkusername/{username}")
	public ResponseEntity<ApiResponse<Object>> checkUsernameAvailability(@PathVariable String username) {
	    boolean available = !service.existsByUsername(username);
	    EmailUserCheckDto dto = new EmailUserCheckDto(available);
	    ApiResponse<Object> response = new ApiResponse<Object>(HttpStatus.OK.value(), true, LocalDateTime.now(),"Success", dto, null);
	    return new ResponseEntity<ApiResponse<Object>>(response, HttpStatus.OK);
	}
	
	
	@GetMapping("/checkemail/{email}")
	public ResponseEntity<ApiResponse<Object>> checkEmailAvailability(@PathVariable String email) {
	    boolean available = !service.existsByEmail(email);
	    EmailUserCheckDto dto = new EmailUserCheckDto(available);
	    ApiResponse<Object> response = new ApiResponse<Object>(HttpStatus.OK.value(), true, LocalDateTime.now(),"Success", dto, null);
	    return new ResponseEntity<ApiResponse<Object>>(response, HttpStatus.OK);

	    
	}
}

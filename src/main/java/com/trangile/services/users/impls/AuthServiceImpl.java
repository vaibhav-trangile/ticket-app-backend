package com.trangile.services.users.impls;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.trangile.exception.InvalidCredentialsException;
import com.trangile.services.security.AuthUserDetailsService;
import com.trangile.services.security.UserDetailsImpl;
import com.trangile.services.security.jwt.JwtUtil;
import com.trangile.services.users.AuthService;
import com.trangile.ui.req.dto.LoginDto;
import com.trangile.ui.res.dto.AuthResponse;
import com.trangile.util.AppConstants;


@Service
public class AuthServiceImpl implements AuthService{
	
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthUserDetailsService userDetailsService;
	

	@Override
	public AuthResponse validateAndGenerateToken(LoginDto dto) throws InvalidCredentialsException {
		try {
			authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUserName(), dto.getPassword()));
		} catch (AuthenticationException e) {
			throw new InvalidCredentialsException("Invalid Username and Password :: " +e);
		}
		final UserDetailsImpl userByUsername = (UserDetailsImpl) userDetailsService.loadUserByUsername(dto.getUserName());
//		String token = jwtUtil.generateToken(userByUsername.getUsername());
		Collection<? extends GrantedAuthority> authorities = userByUsername.getAuthorities();
//		return new AuthResponse(jwtUtil.generateToken(userByUsername.getUsername(), userByUsername.getAuthorities()), AppConstants.EXPIRATION_TIME);
		return new AuthResponse(jwtUtil.generateToken(userByUsername), AppConstants.EXPIRATION_TIME);
	}

}

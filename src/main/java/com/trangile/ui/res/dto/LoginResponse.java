package com.trangile.ui.res.dto;

import java.util.Objects;

public class LoginResponse {
	
	
	private String token;
	private String token_valid;
	
	public LoginResponse() {
		
	}

	public LoginResponse(String token, String token_valid) {
		this.token = token;
		this.token_valid = token_valid;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken_valid() {
		return token_valid;
	}

	public void setToken_valid(String token_valid) {
		this.token_valid = token_valid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(token, token_valid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginResponse other = (LoginResponse) obj;
		return Objects.equals(token, other.token) && Objects.equals(token_valid, other.token_valid);
	}

	@Override
	public String toString() {
		return "LoginResponse [token=" + token + ", token_valid=" + token_valid + "]";
	}
	
}

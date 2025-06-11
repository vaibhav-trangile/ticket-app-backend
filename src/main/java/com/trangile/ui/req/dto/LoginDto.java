package com.trangile.ui.req.dto;

import java.util.Objects;

public class LoginDto {
	
//	@NotBlank(message = "User name cannot be blank.")
	private String userName;
	
//	@NotBlank(message = "Password cannot be blank.")
	private String password;
	
	public LoginDto() {
		
	}

	public LoginDto(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginDto other = (LoginDto) obj;
		return Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "LoginDto [userName=" + userName + ", password=" + password + "]";
	}
}
package com.trangile.ui.req.dto;

import java.util.List;
import java.util.Objects;

public class UserFormDto {
	
	
	private String userName;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String password;
	
	private String phoneNumber;
	
	List<String> roles;

	public UserFormDto() {
		
	}

	public UserFormDto(String userName, String firstName, String lastName, String email, String password,
			String phoneNumber, List<String> roles) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, lastName, password, phoneNumber, roles, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFormDto other = (UserFormDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(roles, other.roles)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "UserFormDto [userName=" + userName + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", phoneNumber=" + phoneNumber + ", roles=" + roles + "]";
	}
}
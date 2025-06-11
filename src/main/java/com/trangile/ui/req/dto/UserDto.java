package com.trangile.ui.req.dto;

import java.util.List;
import java.util.Objects;

public class UserDto {
	
//	@NotBlank(message = "User name cannot be blank.")
	private String userName;
	
//	@NotBlank(message = "Full name cannot be blank.")
	private String fullName;
	
//	@NotBlank(message = "Email cannot be blank.")  // Ensures the field is not null and not empty
//    @Email(message = "Email should be valid") 
	private String email;
	
//	@NotBlank(message = "Password cannot be blank.")
	private String password;
	
//	@NotBlank(message = "Email cannot be blank.")
	private String createdBy;
	
	private Boolean isActive;
	
	List<String> roles;

	public UserDto() {
		
	}

	

	public UserDto(String userName, String fullName, String email, String password, String createdBy,
			List<String> roles) {
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.createdBy = createdBy;
		this.roles = roles;
	}

	public UserDto(String userName, String fullName, String email, String password, String createdBy, Boolean isActive,
			List<String> roles) {
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.createdBy = createdBy;
		this.isActive = isActive;
		this.roles = roles;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, fullName, password, roles, userName);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(password, other.password) && Objects.equals(roles, other.roles)
				&& Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "UserDto [userName=" + userName + ", fullName=" + fullName + ", email=" + email + ", password="
				+ password + ", roles=" + roles + "]";
	}
}
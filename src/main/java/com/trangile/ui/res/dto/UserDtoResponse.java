package com.trangile.ui.res.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class UserDtoResponse {
	
	private Long userId;
	
	private String userName;
	
	private String fullName;
	
	private String email;
	
	private String password;
	
	private LocalDateTime createdOn;

	public UserDtoResponse() {
		
	}

	public UserDtoResponse(Long userId, String userName, String fullName, String email, String password,
			LocalDateTime createdOn) {
		this.userId = userId;
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.createdOn = createdOn;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdOn, email, fullName, password, userId, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDtoResponse other = (UserDtoResponse) obj;
		return Objects.equals(createdOn, other.createdOn) && Objects.equals(email, other.email)
				&& Objects.equals(fullName, other.fullName) && Objects.equals(password, other.password)
				&& Objects.equals(userId, other.userId) && Objects.equals(userName, other.userName);
	}

	@Override
	public String toString() {
		return "UserDtoResponse [userId=" + userId + ", userName=" + userName + ", fullName=" + fullName + ", email="
				+ email + ", password=" + password + ", createdOn=" + createdOn + "]";
	}
}

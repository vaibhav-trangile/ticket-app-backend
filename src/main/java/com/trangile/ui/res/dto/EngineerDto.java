package com.trangile.ui.res.dto;

import java.util.Objects;

public class EngineerDto {
	
	private String fullName;
	private String email;
	private Boolean isAssigned;
	
	public EngineerDto() {
		
	}
	public EngineerDto(String fullName, String email, Boolean isAssigned) {
		this.fullName = fullName;
		this.email = email;
		this.isAssigned = isAssigned;
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
	public Boolean getIsAssigned() {
		return isAssigned;
	}
	public void setIsAssigned(Boolean isAssigned) {
		this.isAssigned = isAssigned;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, fullName, isAssigned);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EngineerDto other = (EngineerDto) obj;
		return Objects.equals(email, other.email) && Objects.equals(fullName, other.fullName)
				&& Objects.equals(isAssigned, other.isAssigned);
	}
	@Override
	public String toString() {
		return "EngineerDto [fullName=" + fullName + ", email=" + email + ", isAssigned=" + isAssigned + "]";
	}
}

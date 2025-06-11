package com.trangile.ui.res.dto;

import java.util.Objects;

public class AuthResponse {

	private String access_token;
	private String type;
	private long expiration;
	

	public AuthResponse() {
		this.type = "Bearer";
	}
	
	
	public AuthResponse(String access_token, long expiration) {
		this.access_token = access_token;
		this.type = "Bearer";
		this.expiration = expiration;
	}


	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public long getExpiration() {
		return expiration;
	}

	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}


	@Override
	public int hashCode() {
		return Objects.hash(access_token, expiration, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthResponse other = (AuthResponse) obj;
		return Objects.equals(access_token, other.access_token) && expiration == other.expiration
				&& Objects.equals(type, other.type);
	}


	@Override
	public String toString() {
		return "AuthResponse [access_token=" + access_token + ", type=" + type + ", expiration=" + expiration + "]";
	}
}
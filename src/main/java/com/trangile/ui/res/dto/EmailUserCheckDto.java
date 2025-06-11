package com.trangile.ui.res.dto;

public class EmailUserCheckDto {
	
	private Boolean available;

	public EmailUserCheckDto() {
		// TODO Auto-generated constructor stub
	}

	public EmailUserCheckDto(Boolean available) {
		this.available = available;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "EmailUserCheckDto [available=" + available + "]";
	}
}

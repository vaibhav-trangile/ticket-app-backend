package com.trangile.ui.req.dto;

import java.util.Objects;

public class RequestDto {
	private String ticketId;
	private Long eventId;
	private String customer;
	private String uploadedBy;
	
	public RequestDto() {
		
	}
	
	public RequestDto(String ticketId, Long eventId, String customer, String uploadedBy) {
		this.ticketId = ticketId;
		this.eventId = eventId;
		this.customer = customer;
		this.uploadedBy = uploadedBy;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customer, eventId, ticketId, uploadedBy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestDto other = (RequestDto) obj;
		return Objects.equals(customer, other.customer) && Objects.equals(eventId, other.eventId)
				&& Objects.equals(ticketId, other.ticketId) && Objects.equals(uploadedBy, other.uploadedBy);
	}

	@Override
	public String toString() {
		return "RequestDto [ticketId=" + ticketId + ", eventId=" + eventId + ", customer=" + customer + ", uploadedBy="
				+ uploadedBy + "]";
	}
}

package com.trangile.ui.req.dto;

import java.util.Objects;

public class Ticket_Event_Req_Dto {
	
	private Long eventId;
	private String ticketId;
	private String eventTitle;
	private String shortDescription;
	private String longDescription;
	private String assignedTo;
	private String status;
	private String fileName;
	private String fileType;
	private String file_url;
	private String createdBy;
	private String updatedBy;
	
	public Ticket_Event_Req_Dto() {
		
	}

	public Ticket_Event_Req_Dto(Long eventId, String ticketId, String eventTitle, String shortDescription,
			String longDescription, String assignedTo, String status, String fileName, String fileType, String file_url,
			String createdBy, String updatedBy) {
		this.eventId = eventId;
		this.ticketId = ticketId;
		this.eventTitle = eventTitle;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.assignedTo = assignedTo;
		this.status = status;
		this.fileName = fileName;
		this.fileType = fileType;
		this.file_url = file_url;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFile_url() {
		return file_url;
	}

	public void setFile_url(String file_url) {
		this.file_url = file_url;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignedTo, createdBy, eventId, eventTitle, fileName, fileType, file_url, longDescription,
				shortDescription, status, ticketId, updatedBy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket_Event_Req_Dto other = (Ticket_Event_Req_Dto) obj;
		return Objects.equals(assignedTo, other.assignedTo) && Objects.equals(createdBy, other.createdBy)
				&& Objects.equals(eventId, other.eventId) && Objects.equals(eventTitle, other.eventTitle)
				&& Objects.equals(fileName, other.fileName) && Objects.equals(fileType, other.fileType)
				&& Objects.equals(file_url, other.file_url) && Objects.equals(longDescription, other.longDescription)
				&& Objects.equals(shortDescription, other.shortDescription) && Objects.equals(status, other.status)
				&& Objects.equals(ticketId, other.ticketId) && Objects.equals(updatedBy, other.updatedBy);
	}

	@Override
	public String toString() {
		return "Ticket_Event_Req_Dto [eventId=" + eventId + ", ticketId=" + ticketId + ", eventTitle=" + eventTitle
				+ ", shortDescription=" + shortDescription + ", longDescription=" + longDescription + ", assignedTo="
				+ assignedTo + ", status=" + status + ", fileName=" + fileName + ", fileType=" + fileType
				+ ", file_url=" + file_url + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}
}
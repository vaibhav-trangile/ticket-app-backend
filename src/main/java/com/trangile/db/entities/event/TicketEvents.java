package com.trangile.db.entities.event;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TICKET_EVENTS")
public class TicketEvents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENTID")
	private Long eventId;
	
	@Column(name = "TICKETID")
	private String ticketId;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "EVENTTITLE")
	private String eventTitle;
	
	@Column(name = "SHORTDESCRIPTION")
	private String shortDescription;
	
	@Column(name = "LONGDESCRIPTION")
	private String longDescription;
	
	@Column(name = "FILENAME")
	private String fileName;
	
	@Column(name = "FILETYPE")
	private String fileType;
	
	@Column(name = "FILEURL")
	private String file_url;
	
	
	@Column(name = "ASSIGNEDTO")
	private String assignedTo;
	
	@CreationTimestamp
	@Column(name = "CREATEDON", updatable = false, nullable = false)
	private LocalDateTime createdOn;
	
	@Column(name = "CREATEDBY")
	private String createdBy;
	
	@UpdateTimestamp
	@Column(name = "UPDATEDON", insertable = false)
	private LocalDateTime updatedOn;
	
	@Column(name = "UPDATEDBY")
	private String updatedBy;

	public TicketEvents() {
		// TODO Auto-generated constructor stub
	}

	public TicketEvents(Long eventId, String ticketId, String status, String eventTitle, String shortDescription,
			String longDescription, String fileName, String fileType, String file_url, LocalDateTime createdOn,
			String createdBy, LocalDateTime updatedOn, String updatedBy) {
		this.eventId = eventId;
		this.ticketId = ticketId;
		this.status = status;
		this.eventTitle = eventTitle;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.fileName = fileName;
		this.fileType = fileType;
		this.file_url = file_url;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdBy, createdOn, eventId, eventTitle, fileName, fileType, file_url, longDescription,
				shortDescription, status, ticketId, updatedBy, updatedOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketEvents other = (TicketEvents) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(createdOn, other.createdOn)
				&& Objects.equals(eventId, other.eventId) && Objects.equals(eventTitle, other.eventTitle)
				&& Objects.equals(fileName, other.fileName) && Objects.equals(fileType, other.fileType)
				&& Objects.equals(file_url, other.file_url) && Objects.equals(longDescription, other.longDescription)
				&& Objects.equals(shortDescription, other.shortDescription) && Objects.equals(status, other.status)
				&& Objects.equals(ticketId, other.ticketId) && Objects.equals(updatedBy, other.updatedBy)
				&& Objects.equals(updatedOn, other.updatedOn);
	}

	@Override
	public String toString() {
		return "TicketEvents [eventId=" + eventId + ", ticketId=" + ticketId + ", status=" + status + ", eventTitle="
				+ eventTitle + ", shortDescription=" + shortDescription + ", longDescription=" + longDescription
				+ ", fileName=" + fileName + ", fileType=" + fileType + ", file_url=" + file_url + ", createdOn="
				+ createdOn + ", createdBy=" + createdBy + ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy
				+ "]";
	}
}

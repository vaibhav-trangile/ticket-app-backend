package com.trangile.ui.res.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Event {
	
	private String eventTitle;
	private LocalDateTime createdOn;
	private String status;
	private String shortDescription;
	private String longDescription;
	private String createdBy;
	private String assignedTo;
	private List<Attachment> attachments;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}

	public Event(String eventTitle, LocalDateTime createdOn, String status, String shortDescription,
			String longDescription, String createdBy, String assignedTo, List<Attachment> attachments) {
		this.eventTitle = eventTitle;
		this.createdOn = createdOn;
		this.status = status;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
		this.createdBy = createdBy;
		this.assignedTo = assignedTo;
		this.attachments = attachments;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(assignedTo, attachments, createdBy, createdOn, eventTitle, longDescription,
				shortDescription, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		return Objects.equals(assignedTo, other.assignedTo) && Objects.equals(attachments, other.attachments)
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(createdOn, other.createdOn)
				&& Objects.equals(eventTitle, other.eventTitle)
				&& Objects.equals(longDescription, other.longDescription)
				&& Objects.equals(shortDescription, other.shortDescription) && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "Event [eventTitle=" + eventTitle + ", createdOn=" + createdOn + ", status=" + status
				+ ", shortDescription=" + shortDescription + ", longDescription=" + longDescription + ", createdBy="
				+ createdBy + ", assignedTo=" + assignedTo + ", attachments=" + attachments + "]";
	}
}
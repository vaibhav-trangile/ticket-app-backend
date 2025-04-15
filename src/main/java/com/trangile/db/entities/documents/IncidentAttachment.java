package com.trangile.db.entities.documents;

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
@Table(name = "Ticket_Attachments")
public class IncidentAttachment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATTACHMENTID")
	private Long attachmentId;
	
	@Column(name = "TICKETID")	
	private String ticketId;
	
	@Column(name = "EVENTID")
	private Long eventId;
	
	@Column(name = "FILENAME")
	private String fileName;
	
	@Column(name = "CUSTOMER")
	private String customer;
	
	@Column(name = "FILEURL")
	private String fileUrl;
	
	
	@Column(name = "FILESIZE")
	private String fileSize;
	
	@Column(name = "CONTENTTYPE")
	private String contentType;

	@Column(name = "DELETED")
	private Character deleted;
	
	@Column(name = "DELETEDAT")
	private Character deletedAt;
	
	@Column(name = "DELETEDBY")
	private Character deletedBy;
	
	@CreationTimestamp
	@Column(name = "UPLOADEDAT", updatable = false)
	private LocalDateTime uploadedAt;
	
	@Column(name = "UPLOADEDBY")
	private String uploadedBy;
	
	@UpdateTimestamp
	@Column(name = "UPDATEDAT", insertable = false)
	private LocalDateTime updatedAt;
	
	@Column(name = "UPDATEDBY")
	private String updatedBy;

	public IncidentAttachment() {
		
	}

	public IncidentAttachment(Long attachmentId, String ticketId, Long eventId, String fileName, String customer,
			String fileUrl, String fileSize, String contentType, Character deleted, Character deletedAt,
			Character deletedBy, LocalDateTime uploadedAt, String uploadedBy, LocalDateTime updatedAt,
			String updatedBy) {
		this.attachmentId = attachmentId;
		this.ticketId = ticketId;
		this.eventId = eventId;
		this.fileName = fileName;
		this.customer = customer;
		this.fileUrl = fileUrl;
		this.fileSize = fileSize;
		this.contentType = contentType;
		this.deleted = deleted;
		this.deletedAt = deletedAt;
		this.deletedBy = deletedBy;
		this.uploadedAt = uploadedAt;
		this.uploadedBy = uploadedBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}




	public Long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
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

	public String getFileName() {
		return fileName;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
	public Character getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Character deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Character getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Character deletedBy) {
		this.deletedBy = deletedBy;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Character getDeleted() {
		return deleted;
	}

	public void setDeleted(Character deleted) {
		this.deleted = deleted;
	}

	public LocalDateTime getUploadedAt() {
		return uploadedAt;
	}

	public void setUploadedAt(LocalDateTime uploadedAt) {
		this.uploadedAt = uploadedAt;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}
	
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(attachmentId, contentType, deleted, deletedAt, deletedBy, eventId, fileName, fileSize,
				fileUrl, ticketId, updatedAt, updatedBy, uploadedAt, uploadedBy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncidentAttachment other = (IncidentAttachment) obj;
		return Objects.equals(attachmentId, other.attachmentId) && Objects.equals(contentType, other.contentType)
				&& Objects.equals(deleted, other.deleted) && Objects.equals(deletedAt, other.deletedAt)
				&& Objects.equals(deletedBy, other.deletedBy) && Objects.equals(eventId, other.eventId)
				&& Objects.equals(fileName, other.fileName) && Objects.equals(fileSize, other.fileSize)
				&& Objects.equals(fileUrl, other.fileUrl) && Objects.equals(ticketId, other.ticketId)
				&& Objects.equals(updatedAt, other.updatedAt) && Objects.equals(updatedBy, other.updatedBy)
				&& Objects.equals(uploadedAt, other.uploadedAt) && Objects.equals(uploadedBy, other.uploadedBy);
	}

	@Override
	public String toString() {
		return "TicketAttachments [attachmentId=" + attachmentId + ", ticketId=" + ticketId + ", eventId=" + eventId
				+ ", fileName=" + fileName + ", fileUrl=" + fileUrl + ", fileSize=" + fileSize + ", contentType="
				+ contentType + ", deleted=" + deleted + ", deletedAt=" + deletedAt + ", deletedBy=" + deletedBy
				+ ", uploadedAt=" + uploadedAt + ", uploadedBy=" + uploadedBy + ", updatedAt=" + updatedAt
				+ ", updatedBy=" + updatedBy + "]";
	}
}
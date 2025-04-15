package com.trangile.db.entities.incident;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.trangile.db.entities.listeners.TicketGeneratorListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TICKETSDETAILS")
@EntityListeners(TicketGeneratorListener.class)
public class Tickets {
	
	@Id
	@Column(name = "TICKETID")
	private String ticketId;
	
	@Column(name = "PROJECT")
	private String project;
	
	@Column(name = "DESCRIPTION")
	private String description;
		
	@Column(name = "STATUS", nullable = false)
	private String status;
	
	@Column(name = "REMARKS")
	private String remarks;
	
	@Column(name = "RAISEDON")
	private LocalDateTime issueRaisedOn;
	
	@Column(name = "RAISEDBY")
	private String raisedBy;
	
	
	@Column(name = "ASSIGNEDON")
	private LocalDateTime assignedOn;
	
	@Column(name = "ASSIGNEDTO")
	private String assignedTo;

	@Column(name = "RESOLVEDON")
	private LocalDateTime resolvedOn;
	
	
	@Column(name = "RESOLVEDBY")
	private String resolvedBy;
	
	@Column(name = "ENVIRONMENT")
	private String environment;
	
	@Column(name = "SUPPORTTYPE")
	private String supportType;
	
	@Column(name = "SERVICETYPE")
	private String serviceType;
	
	@Column(name = "SUMMARY")
	private String summary;
	
	@Column(name = "FUNCTIONNAME")
	private String functionName;
	
	@Column(name = "SUBFUNCTION")
	private String subFunctionName;
	
	@Column(name = "RESOLUTIONTIMEINMIN")
	private Long resolutionTimeTakenInMin;
	
	@Column(name = "ASSIGNEDTIMEINMIN")
	private Long assignedTimeTakenInMin;
	
	@Column(name = "ACTUALTIMEINMIN")
	private Long actualTimeTakenInMin;
	
	@Column(name = "MONTHYEAR")
	private String monthYear;
	
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
	


	public Tickets() {
		
	}



	public Tickets(String ticketId, String project, String description, String status, String remarks,
			LocalDateTime issueRaisedOn, String raisedBy, LocalDateTime assignedOn, String assignedTo,
			LocalDateTime resolvedOn, String resolvedBy, String environment, String supportType, String serviceType,
			String summary, String functionName, String subFunctionName, Long resolutionTimeTakenInMin,
			Long assignedTimeTakenInMin, Long actualTimeTakenInMin, String monthYear, LocalDateTime createdOn,
			String createdBy, LocalDateTime updatedOn, String updatedBy) {
		this.ticketId = ticketId;
		this.project = project;
		this.description = description;
		this.status = status;
		this.remarks = remarks;
		this.issueRaisedOn = issueRaisedOn;
		this.raisedBy = raisedBy;
		this.assignedOn = assignedOn;
		this.assignedTo = assignedTo;
		this.resolvedOn = resolvedOn;
		this.resolvedBy = resolvedBy;
		this.environment = environment;
		this.supportType = supportType;
		this.serviceType = serviceType;
		this.summary = summary;
		this.functionName = functionName;
		this.subFunctionName = subFunctionName;
		this.resolutionTimeTakenInMin = resolutionTimeTakenInMin;
		this.assignedTimeTakenInMin = assignedTimeTakenInMin;
		this.actualTimeTakenInMin = actualTimeTakenInMin;
		this.monthYear = monthYear;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
		this.updatedOn = updatedOn;
		this.updatedBy = updatedBy;
	}



	public String getTicketId() {
		return ticketId;
	}



	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}



	public String getProject() {
		return project;
	}



	public void setProject(String project) {
		this.project = project;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getRemarks() {
		return remarks;
	}



	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public LocalDateTime getIssueRaisedOn() {
		return issueRaisedOn;
	}



	public void setIssueRaisedOn(LocalDateTime issueRaisedOn) {
		this.issueRaisedOn = issueRaisedOn;
	}



	public String getRaisedBy() {
		return raisedBy;
	}



	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
	}



	public LocalDateTime getAssignedOn() {
		return assignedOn;
	}



	public void setAssignedOn(LocalDateTime assignedOn) {
		this.assignedOn = assignedOn;
	}



	public String getAssignedTo() {
		return assignedTo;
	}



	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}



	public LocalDateTime getResolvedOn() {
		return resolvedOn;
	}



	public void setResolvedOn(LocalDateTime resolvedOn) {
		this.resolvedOn = resolvedOn;
	}



	public String getResolvedBy() {
		return resolvedBy;
	}



	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}



	public String getEnvironment() {
		return environment;
	}



	public void setEnvironment(String environment) {
		this.environment = environment;
	}



	public String getSupportType() {
		return supportType;
	}



	public void setSupportType(String supportType) {
		this.supportType = supportType;
	}



	public String getServiceType() {
		return serviceType;
	}



	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getFunctionName() {
		return functionName;
	}



	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}



	public String getSubFunctionName() {
		return subFunctionName;
	}



	public void setSubFunctionName(String subFunctionName) {
		this.subFunctionName = subFunctionName;
	}



	public Long getResolutionTimeTakenInMin() {
		return resolutionTimeTakenInMin;
	}



	public void setResolutionTimeTakenInMin(Long resolutionTimeTakenInMin) {
		this.resolutionTimeTakenInMin = resolutionTimeTakenInMin;
	}



	public Long getAssignedTimeTakenInMin() {
		return assignedTimeTakenInMin;
	}



	public void setAssignedTimeTakenInMin(Long assignedTimeTakenInMin) {
		this.assignedTimeTakenInMin = assignedTimeTakenInMin;
	}



	public Long getActualTimeTakenInMin() {
		return actualTimeTakenInMin;
	}



	public void setActualTimeTakenInMin(Long actualTimeTakenInMin) {
		this.actualTimeTakenInMin = actualTimeTakenInMin;
	}



	public String getMonthYear() {
		return monthYear;
	}



	public void setMonthYear(String monthYear) {
		this.monthYear = monthYear;
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



	@Override
	public int hashCode() {
		return Objects.hash(actualTimeTakenInMin, assignedOn, assignedTimeTakenInMin, assignedTo, createdBy, createdOn,
				description, environment, functionName, issueRaisedOn, monthYear, project, raisedBy, remarks,
				resolutionTimeTakenInMin, resolvedBy, resolvedOn, serviceType, status, subFunctionName, summary,
				supportType, ticketId, updatedBy, updatedOn);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tickets other = (Tickets) obj;
		return Objects.equals(actualTimeTakenInMin, other.actualTimeTakenInMin)
				&& Objects.equals(assignedOn, other.assignedOn)
				&& Objects.equals(assignedTimeTakenInMin, other.assignedTimeTakenInMin)
				&& Objects.equals(assignedTo, other.assignedTo) && Objects.equals(createdBy, other.createdBy)
				&& Objects.equals(createdOn, other.createdOn) && Objects.equals(description, other.description)
				&& Objects.equals(environment, other.environment) && Objects.equals(functionName, other.functionName)
				&& Objects.equals(issueRaisedOn, other.issueRaisedOn) && Objects.equals(monthYear, other.monthYear)
				&& Objects.equals(project, other.project) && Objects.equals(raisedBy, other.raisedBy)
				&& Objects.equals(remarks, other.remarks)
				&& Objects.equals(resolutionTimeTakenInMin, other.resolutionTimeTakenInMin)
				&& Objects.equals(resolvedBy, other.resolvedBy) && Objects.equals(resolvedOn, other.resolvedOn)
				&& Objects.equals(serviceType, other.serviceType) && Objects.equals(status, other.status)
				&& Objects.equals(subFunctionName, other.subFunctionName) && Objects.equals(summary, other.summary)
				&& Objects.equals(supportType, other.supportType) && Objects.equals(ticketId, other.ticketId)
				&& Objects.equals(updatedBy, other.updatedBy) && Objects.equals(updatedOn, other.updatedOn);
	}



	@Override
	public String toString() {
		return "Tickets [ticketId=" + ticketId + ", project=" + project + ", description=" + description + ", status="
				+ status + ", remarks=" + remarks + ", issueRaisedOn=" + issueRaisedOn + ", raisedBy=" + raisedBy
				+ ", assignedOn=" + assignedOn + ", assignedTo=" + assignedTo + ", resolvedOn=" + resolvedOn
				+ ", resolvedBy=" + resolvedBy + ", environment=" + environment + ", supportType=" + supportType
				+ ", serviceType=" + serviceType + ", summary=" + summary + ", functionName=" + functionName
				+ ", subFunctionName=" + subFunctionName + ", resolutionTimeTakenInMin=" + resolutionTimeTakenInMin
				+ ", assignedTimeTakenInMin=" + assignedTimeTakenInMin + ", actualTimeTakenInMin="
				+ actualTimeTakenInMin + ", monthYear=" + monthYear + ", createdOn=" + createdOn + ", createdBy="
				+ createdBy + ", updatedOn=" + updatedOn + ", updatedBy=" + updatedBy + "]";
	}
}
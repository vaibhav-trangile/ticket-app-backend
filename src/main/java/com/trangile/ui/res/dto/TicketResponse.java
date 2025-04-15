package com.trangile.ui.res.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class TicketResponse {
	private String ticketId;
	private String project;
	private String description;	
	private String status;
	private String remarks;
	private LocalDateTime assignedOn;
	private String assignedTo;
	private String resolvedBy;
	private LocalDate resolvedOn;
	private String createdBy;
	private String updatedBy;
	private String environment;
	private String supportType;
	private String serviceType;
	private String raisedBy;
	private String summary;
	private String functionName;
	private String subFunctionName;
	private Long actualTimeTakenInMin;
	
	public TicketResponse() {
		
	}
	
	

	public TicketResponse(String ticketId, String project, String description, String status, String remarks,
			LocalDateTime assignedOn, String assignedTo, String resolvedBy, LocalDate resolvedOn, String createdBy,
			String updatedBy, String environment, String supportType, String serviceType, String raisedBy,
			String summary, String functionName, String subFunctionName, Long actualTimeTakenInMin) {
		this.ticketId = ticketId;
		this.project = project;
		this.description = description;
		this.status = status;
		this.remarks = remarks;
		this.assignedOn = assignedOn;
		this.assignedTo = assignedTo;
		this.resolvedBy = resolvedBy;
		this.resolvedOn = resolvedOn;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.environment = environment;
		this.supportType = supportType;
		this.serviceType = serviceType;
		this.raisedBy = raisedBy;
		this.summary = summary;
		this.functionName = functionName;
		this.subFunctionName = subFunctionName;
		this.actualTimeTakenInMin = actualTimeTakenInMin;
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

	public String getResolvedBy() {
		return resolvedBy;
	}

	public void setResolvedBy(String resolvedBy) {
		this.resolvedBy = resolvedBy;
	}

	public LocalDate getResolvedOn() {
		return resolvedOn;
	}

	public void setResolvedOn(LocalDate resolvedOn) {
		this.resolvedOn = resolvedOn;
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

	public String getRaisedBy() {
		return raisedBy;
	}

	public void setRaisedBy(String raisedBy) {
		this.raisedBy = raisedBy;
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

	public Long getActualTimeTakenInMin() {
		return actualTimeTakenInMin;
	}

	public void setActualTimeTakenInMin(Long actualTimeTakenInMin) {
		this.actualTimeTakenInMin = actualTimeTakenInMin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actualTimeTakenInMin, assignedOn, assignedTo, createdBy, description, environment,
				functionName, project, raisedBy, remarks, resolvedBy, resolvedOn, serviceType, status, subFunctionName,
				summary, supportType, ticketId, updatedBy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketResponse other = (TicketResponse) obj;
		return Objects.equals(actualTimeTakenInMin, other.actualTimeTakenInMin)
				&& Objects.equals(assignedOn, other.assignedOn) && Objects.equals(assignedTo, other.assignedTo)
				&& Objects.equals(createdBy, other.createdBy) && Objects.equals(description, other.description)
				&& Objects.equals(environment, other.environment) && Objects.equals(functionName, other.functionName)
				&& Objects.equals(project, other.project) && Objects.equals(raisedBy, other.raisedBy)
				&& Objects.equals(remarks, other.remarks) && Objects.equals(resolvedBy, other.resolvedBy)
				&& Objects.equals(resolvedOn, other.resolvedOn) && Objects.equals(serviceType, other.serviceType)
				&& Objects.equals(status, other.status) && Objects.equals(subFunctionName, other.subFunctionName)
				&& Objects.equals(summary, other.summary) && Objects.equals(supportType, other.supportType)
				&& Objects.equals(ticketId, other.ticketId) && Objects.equals(updatedBy, other.updatedBy);
	}

	@Override
	public String toString() {
		return "TicketResponse [ticketId=" + ticketId + ", project=" + project + ", description=" + description
				+ ", status=" + status + ", remarks=" + remarks + ", assignedOn=" + assignedOn + ", assignedTo="
				+ assignedTo + ", resolvedBy=" + resolvedBy + ", resolvedOn=" + resolvedOn + ", createdBy=" + createdBy
				+ ", updatedBy=" + updatedBy + ", environment=" + environment + ", supportType=" + supportType
				+ ", serviceType=" + serviceType + ", raisedBy=" + raisedBy + ", summary=" + summary + ", functionName="
				+ functionName + ", subFunctionName=" + subFunctionName + ", actualTimeTakenInMin="
				+ actualTimeTakenInMin + "]";
	}
}

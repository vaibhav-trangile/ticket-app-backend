package com.trangile.ui.req.dto;

import java.util.Objects;

public class TicketRequest {
	
	private String project;
	private String description;
	private Integer status;
	private String environment;
	private String supportType;
	private String serviceType;
	private String raisedBy;
	private String summary;
	private String functionName;
	private String subFunctionName;
	private String createdBy;
	
	public TicketRequest() {
		
	}

	public TicketRequest(String project, String description, Integer status,
			String environment, String supportType, String serviceType, String raisedBy, String summary,
			String functionName, String subFunctionName, String createdBy) {
		this.project = project;
		this.description = description;
		this.status = status;
		this.environment = environment;
		this.supportType = supportType;
		this.serviceType = serviceType;
		this.raisedBy = raisedBy;
		this.summary = summary;
		this.functionName = functionName;
		this.subFunctionName = subFunctionName;
		this.createdBy = createdBy;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdBy, description, environment, functionName, project, raisedBy, serviceType,
				status, subFunctionName, summary, supportType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketRequest other = (TicketRequest) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(description, other.description)
				&& Objects.equals(environment, other.environment) && Objects.equals(functionName, other.functionName)
				&& Objects.equals(project, other.project) && Objects.equals(raisedBy, other.raisedBy)
				&& Objects.equals(serviceType, other.serviceType)
				&& Objects.equals(status, other.status)
				&& Objects.equals(subFunctionName, other.subFunctionName) && Objects.equals(summary, other.summary)
				&& Objects.equals(supportType, other.supportType);
	}

	@Override
	public String toString() {
		return "TicketRequest [project=" + project + ", description=" + description + ", status=" + status
				+ ", environment=" + environment + ", supportType=" + supportType + ", serviceType=" + serviceType
				+ ", raisedBy=" + raisedBy + ", summary=" + summary + ", functionName=" + functionName
				+ ", subFunctionName=" + subFunctionName + ", createdBy=" + createdBy + "]";
	}
}

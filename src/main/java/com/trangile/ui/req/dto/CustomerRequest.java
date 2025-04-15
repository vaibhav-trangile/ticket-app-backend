package com.trangile.ui.req.dto;

import java.util.Objects;

public class CustomerRequest {
	
	private String customerName;
	
	private String customerAdd;
	
	private String customerPhone;
	
	private String customerEmail;
	
	private String customerDomain;
	
	private Character isActive;
	
	private String createdBy;

	public CustomerRequest() {
		
	}

	public CustomerRequest(String customerName, String customerAdd, String customerPhone, String customerEmail,
			String customerDomain, Character isActive, String createdBy) {
		this.customerName = customerName;
		this.customerAdd = customerAdd;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerDomain = customerDomain;
		this.isActive = isActive;
		this.createdBy = createdBy;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAdd() {
		return customerAdd;
	}

	public void setCustomerAdd(String customerAdd) {
		this.customerAdd = customerAdd;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerDomain() {
		return customerDomain;
	}

	public void setCustomerDomain(String customerDomain) {
		this.customerDomain = customerDomain;
	}

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdBy, customerAdd, customerDomain, customerEmail, customerName, customerPhone,
				isActive);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerRequest other = (CustomerRequest) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(customerAdd, other.customerAdd)
				&& Objects.equals(customerDomain, other.customerDomain)
				&& Objects.equals(customerEmail, other.customerEmail)
				&& Objects.equals(customerName, other.customerName)
				&& Objects.equals(customerPhone, other.customerPhone) && Objects.equals(isActive, other.isActive);
	}

	@Override
	public String toString() {
		return "CustomerRequest [customerName=" + customerName + ", customerAdd=" + customerAdd + ", customerPhone="
				+ customerPhone + ", customerEmail=" + customerEmail + ", customerDomain=" + customerDomain
				+ ", isActive=" + isActive + ", createdBy=" + createdBy + "]";
	}	
}
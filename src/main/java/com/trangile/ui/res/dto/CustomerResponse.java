package com.trangile.ui.res.dto;

import java.util.Objects;

public class CustomerResponse {
	
	private Long customerId;

	private String customerName;
	
	private String customerAdd;
	
	private String customerPhone;
	
	private String customerEmail;
	
	private String customerDomain;
	
	private Character isActive;
	
	private Character isDeleted;

	public CustomerResponse() {
		
	}

	public CustomerResponse(String customerName, String customerEmail, String customerPhone, String customerAdd,
			String customerDomain) {
		this.customerName = customerName;
		this.customerAdd = customerAdd;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerDomain = customerDomain;
	}

	public CustomerResponse(Long customerId, String customerName, String customerAdd, String customerPhone,
			String customerEmail, String customerDomain, Character isActive, Character isDeleted) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAdd = customerAdd;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerDomain = customerDomain;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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

	public Character getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Character isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerAdd, customerDomain, customerEmail, customerId, customerName, customerPhone,
				isActive, isDeleted);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerResponse other = (CustomerResponse) obj;
		return Objects.equals(customerAdd, other.customerAdd) && Objects.equals(customerDomain, other.customerDomain)
				&& Objects.equals(customerEmail, other.customerEmail) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(customerName, other.customerName)
				&& Objects.equals(customerPhone, other.customerPhone) && Objects.equals(isActive, other.isActive)
				&& Objects.equals(isDeleted, other.isDeleted);
	}

	@Override
	public String toString() {
		return "CustomerResponse [customerId=" + customerId + ", customerName=" + customerName + ", customerAdd="
				+ customerAdd + ", customerPhone=" + customerPhone + ", customerEmail=" + customerEmail
				+ ", customerDomain=" + customerDomain + ", isActive=" + isActive + ", isDeleted=" + isDeleted + "]";
	}	
}

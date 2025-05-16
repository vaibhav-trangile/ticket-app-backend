package com.trangile.ui.res.dto;

import java.util.Objects;

public class CustomerResponse {
	
	private Long customerId;

	private String customerName;
	
	private String customerAdd;
	
	private String customerPhone;
	
	private String customerEmail;
	
	private String customerNumber;

	public CustomerResponse() {
		// TODO Auto-generated constructor stub
	}

	public CustomerResponse(String customerName, String customerAdd, String customerPhone, String customerEmail,
			String customerNumber) {
		this.customerName = customerName;
		this.customerAdd = customerAdd;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerNumber = customerNumber;
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

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerAdd, customerEmail, customerName, customerNumber, customerPhone);
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
		return Objects.equals(customerAdd, other.customerAdd) && Objects.equals(customerEmail, other.customerEmail)
				&& Objects.equals(customerName, other.customerName)
				&& Objects.equals(customerNumber, other.customerNumber)
				&& Objects.equals(customerPhone, other.customerPhone);
	}

	@Override
	public String toString() {
		return "CustomerResponse [customerName=" + customerName + ", customerAdd=" + customerAdd + ", customerPhone="
				+ customerPhone + ", customerEmail=" + customerEmail + ", customerNumber=" + customerNumber + "]";
	}

}

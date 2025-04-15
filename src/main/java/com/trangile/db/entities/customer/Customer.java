package com.trangile.db.entities.customer;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
@SequenceGenerator(
	    name = "customer_seq_generator",
	    sequenceName = "customer_id_seq",
	    initialValue = 1001,
	    allocationSize = 1
	)
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq_generator")
	@Column(name = "CUSTOMERID")
	private Long customerId;
	
	@Column(name = "CUSTOMERNAME")
	private String customerName;
	
	@Column(name = "CUSTOMERADD")
	private String customerAdd;
	
	@Column(name = "CUSTOMERPHONE")
	private String customerPhone;
	
	@Column(name = "CUSTOMEREMAIL")
	private String customerEmail;
	
	
	@Column(name = "CUSTOMERNUMBER")
	private String customerNumber;
	
	@Column(name = "DOMAIN")
	private String customerDomain;
	
	@Column(name = "ISACTIVE")
	private Character isActive;
	
	@Column(name = "ISDELETED")
	private Character isDeleted;	
	
	@Column(name = "CREATEDBY")
	private String createdBy;
	
	@CreationTimestamp
	@Column(name = "CREATEDON", updatable = false, insertable = true)
	private LocalDateTime createdOn;
	
	@Column(name = "UPDATEDBY")
	private String updatedBy;

	
	@UpdateTimestamp
	@Column(name = "UPDATEDON", updatable = true, insertable = false)
	private LocalDateTime updatedOn;
		
	public Customer() {
		
	}

	public Customer(Long customerId, String customerName, String customerAdd, String customerPhone,
			String customerEmail, String customerNumber, String customerDomain, Character isActive, Character isDeleted,
			String createdBy, LocalDateTime createdOn, String updatedBy, LocalDateTime updatedOn) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerAdd = customerAdd;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerNumber = customerNumber;
		this.customerDomain = customerDomain;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdBy, createdOn, customerAdd, customerDomain, customerEmail, customerId, customerName,
				customerNumber, customerPhone, isActive, isDeleted, updatedBy, updatedOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(createdOn, other.createdOn)
				&& Objects.equals(customerAdd, other.customerAdd)
				&& Objects.equals(customerDomain, other.customerDomain)
				&& Objects.equals(customerEmail, other.customerEmail) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(customerName, other.customerName)
				&& Objects.equals(customerNumber, other.customerNumber)
				&& Objects.equals(customerPhone, other.customerPhone) && Objects.equals(isActive, other.isActive)
				&& Objects.equals(isDeleted, other.isDeleted) && Objects.equals(updatedBy, other.updatedBy)
				&& Objects.equals(updatedOn, other.updatedOn);
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAdd=" + customerAdd
				+ ", customerPhone=" + customerPhone + ", customerEmail=" + customerEmail + ", customerNumber="
				+ customerNumber + ", customerDomain=" + customerDomain + ", isActive=" + isActive + ", isDeleted="
				+ isDeleted + ", createdBy=" + createdBy + ", createdOn=" + createdOn + ", updatedBy=" + updatedBy
				+ ", updatedOn=" + updatedOn + "]";
	}
}
package com.trangile.db.repo.customer;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.trangile.db.entities.customer.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Serializable>{
	
	@Query(value = "SELECT * FROM CUSTOMER WHERE (CUSTOMERNAME LIKE CONCAT('%', :name, '%') OR CUSTOMEREMAIL LIKE CONCAT('%', :name, '%') OR CUSTOMERNUMBER LIKE CONCAT('%', :name, '%'))", nativeQuery = true)
	List<Customer> findByNameOrEmailOrPhone(@Param("name") String name);

	@Query(value = "SELECT c.customerName from Customer c")
	List<String> findAllNames();
	
	

}
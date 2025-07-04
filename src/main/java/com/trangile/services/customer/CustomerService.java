package com.trangile.services.customer;

import java.util.List;

import com.trangile.ui.req.dto.CustomerRequest;
import com.trangile.ui.res.dto.CustomerResponse;

public interface CustomerService {
	
	String createCustomer(CustomerRequest request);
	
	List<CustomerResponse> getCustomer(String name);

	List<CustomerResponse> getAllCustomer(String status);

	List<String> getAllCustomerNames();
	
	CustomerResponse getCustomer(Long custId);

	String deleteCustomer(Long custId);

	CustomerResponse updateCustomer(Long custId, CustomerRequest req);

}

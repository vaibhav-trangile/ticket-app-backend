package com.trangile.services.customer.impls;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trangile.db.entities.customer.Customer;
import com.trangile.db.repo.customer.CustomerRepository;
import com.trangile.services.customer.CustomerService;
import com.trangile.ui.req.dto.CustomerRequest;
import com.trangile.ui.res.dto.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepository repo;
	
	@Override
	public String createCustomer(CustomerRequest request) {
		Customer customer = new Customer();
		customer.setCustomerName(request.getCustomerName());
		customer.setCustomerAdd(request.getCustomerAdd());
		customer.setCustomerPhone(request.getCustomerPhone());
		customer.setCustomerEmail(request.getCustomerEmail());
		customer.setCustomerDomain(request.getCustomerDomain());
		customer.setIsActive(request.getIsActive());
		customer.setIsDeleted('N');
		customer.setCreatedBy(request.getCreatedBy());
		Customer save = repo.save(customer);
		return (save.getCustomerId() != null & save.getCustomerId() != 0) ? "Customer Created." : "Something went wrong.";
	}

	@Override
	public List<CustomerResponse> getCustomer(String name) {
		List<Customer> customerByName = repo.findByNameOrEmailOrPhone(name);
		if (customerByName.size() > 0 ) {
			return getCustomerResponse(customerByName);
		}
		return null;
	}

	private List<CustomerResponse> getCustomerResponse(List<Customer> customerByName) {
		if (customerByName == null || customerByName.isEmpty()) {
			return Collections.emptyList();
		}
		return customerByName.stream().map(customer -> new CustomerResponse(customer.getCustomerName(), customer.getCustomerEmail(), null, null, null)).collect(Collectors.toList());
	}

	@Override
	public List<CustomerResponse> getAllCustomer() {
		List<Customer> allCustomers = repo.findAll();
		return  allCustomers.stream().map(c -> {
			CustomerResponse response = new CustomerResponse();
			response.setCustomerName(c.getCustomerName());
			response.setCustomerPhone(c.getCustomerPhone());
			response.setCustomerEmail(c.getCustomerEmail());
			response.setCustomerAdd(c.getCustomerAdd());
			return response;
		}).collect(Collectors.toList());
	}

	@Override
	public List<String> getAllCustomerNames() {
		return repo.findAllNames();
	}

	@Override
	public String deleteCustomer(String name) {
		return null;
	}
	
}
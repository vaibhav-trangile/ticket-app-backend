package com.trangile.services.customer.impls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trangile.db.entities.customer.Customer;
import com.trangile.db.repo.customer.CustomerRepository;
import com.trangile.services.customer.CustomerService;
import com.trangile.services.users.UserService;
import com.trangile.ui.req.dto.CustomerRequest;
import com.trangile.ui.req.dto.UserDto;
import com.trangile.ui.res.dto.CustomerResponse;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private UserService userService;
	
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
		createUser(save);
		return (save.getCustomerId() != null & save.getCustomerId() != 0) ? "Customer Created." : "Something went wrong.";
	}

	private void createUser(Customer save) {
		UserDto dto = new UserDto();
		String valueOfUserName = String.valueOf(save.getCustomerId());
		dto.setUserName(valueOfUserName);
		dto.setEmail(save.getCustomerEmail());
		dto.setFullName(save.getCustomerName());
		dto.setPassword(valueOfUserName + "@#123");
		dto.setCreatedBy(save.getCreatedBy());
		dto.setIsActive(save.getIsActive() == 'Y' ? true : false);
		dto.setRoles(List.of("CUSTOMER"));
		userService.createUser(dto);
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
	public List<CustomerResponse> getAllCustomer(String status) {
		List<Customer> customers = new ArrayList<>();
		if ("inactive".equalsIgnoreCase(status)) {
			customers = repo.getByIsActiveAndIsDeleted('N', 'Y');
		} else {
			customers = repo.getByIsActiveAndIsDeleted('Y', 'N');
		}
		return  customers.stream().map(c -> {
			CustomerResponse response = new CustomerResponse();
			response.setCustomerId(c.getCustomerId());
			response.setCustomerName(c.getCustomerName());
			response.setCustomerPhone(c.getCustomerPhone());
			response.setCustomerEmail(c.getCustomerEmail());
			response.setCustomerAdd(c.getCustomerAdd());
			response.setCustomerDomain(c.getCustomerDomain());
			response.setIsActive(c.getIsActive());
			response.setIsDeleted(c.getIsDeleted());
			return response;
		}).collect(Collectors.toList());
	}

	@Override
	public List<String> getAllCustomerNames() {
		return repo.findAllNames();
	}

	@Override
	public String deleteCustomer(Long custId) {
		Optional<Customer> byId = repo.findById(custId);
		if (byId.isPresent()) {
			Customer customer = byId.get();
			customer.setIsDeleted('Y');
			customer.setIsActive('N');
			userService.deleteUser(String.valueOf(custId));
			repo.save(customer);
			return "Deletion done successfully.";
		}
		return null;
	}

	@Override
	public CustomerResponse getCustomer(Long custId) {
		Optional<Customer> byId = repo.findById(custId);
		if (byId.isPresent()) {
			CustomerResponse reponse = new CustomerResponse();
			BeanUtils.copyProperties(byId.get(), reponse);
			return reponse;
		}
		return null;
	}

	@Override
	public CustomerResponse updateCustomer(Long custId, CustomerRequest req) {
		Optional<Customer> byId = repo.findById(custId);
		if (byId.isPresent()) {
			Customer customer = byId.get();
			BeanUtils.copyProperties(req, customer);
			Customer save = repo.save(customer);
			CustomerResponse reponse = new CustomerResponse();
			BeanUtils.copyProperties(save, reponse);
			return reponse;
		}
		return null;
	}
	
}
package com.trangile.ui.controllers.customer;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trangile.services.customer.CustomerService;
import com.trangile.ui.req.dto.CustomerRequest;
import com.trangile.ui.res.dto.ApiResponse;
import com.trangile.util.AppConstants;

@RestController
@RequestMapping(AppConstants.BASE_URI + AppConstants.BACKEND_API_URI)
@CrossOrigin(AppConstants.CORS_URI)
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/customer")
	public ResponseEntity<String> createCustomer(@RequestBody CustomerRequest req) {
		String customer = customerService.createCustomer(req);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getallnames")
	public ResponseEntity<List<String>> getAllCustomerNames() {
		List<String> customer = customerService.getAllCustomerNames();
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	
	
	@GetMapping(value = "/customers")
	public ResponseEntity<ApiResponse<Object>> createCustomer() {
		ApiResponse<Object> api = new ApiResponse<>();
		api.setCode(HttpStatus.OK.value());
		api.setSuccess(true);
		api.setMessage("Customer retrieved successfully.");
		api.setTime(LocalDateTime.now());
		api.setData(customerService.getAllCustomer());
		return new ResponseEntity<>(api, HttpStatus.OK);
	}
	
	@GetMapping(value = "/customers/{id}")
	public ResponseEntity<ApiResponse<Object>> getCustomerFromId(@PathVariable(value = "id") Long custId) {
		ApiResponse<Object> api = new ApiResponse<>();
		api.setData(customerService.getCustomer(custId));
		return new ResponseEntity<>(api, HttpStatus.OK);
	}
	
	@PutMapping(value = "/customers/{id}")
	public ResponseEntity<ApiResponse<Object>> updateCustomerById(@PathVariable(value = "id") Long custId, @RequestBody CustomerRequest req) {
		ApiResponse<Object> api = new ApiResponse<>();
		api.setData(customerService.updateCustomer(custId, req));
		return new ResponseEntity<>(api, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/customers/{id}")
	public ResponseEntity<ApiResponse<Object>> deleteCustomer(@PathVariable(value = "id") Long custId) {
		ApiResponse<Object> api = new ApiResponse<>();
		api.setData(customerService.deleteCustomer(custId));
		return new ResponseEntity<>(api, HttpStatus.OK);
	}
	
}
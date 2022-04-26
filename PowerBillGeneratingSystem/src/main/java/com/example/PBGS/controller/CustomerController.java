package com.example.PBGS.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.PBGS.exception.ResourceNotFoundException;
import com.example.PBGS.model.Customer;
import com.example.PBGS.repository.CustomerRepository;

@RestControllerAdvice
@RequestMapping("/api/v1/")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	//Get all Customer
	@GetMapping("/customers")
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	//create customer rest api
	@PostMapping("/customers")
	public Customer createCustomer(@RequestBody Customer customer) {
	return customerRepository.save(customer);
	}
	
	//get customer by id rest api
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer customer = customerRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Customer not exist with id : "+ id));
		return ResponseEntity.ok(customer);
	}
	
	//update customer rest api
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails){
		
		Customer customer = customerRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Customer not exist with id : "+ id));
		
		customer.setName(customerDetails.getName());
		customer.setContact(customerDetails.getContact());
		customer.setAddress(customerDetails.getAddress());
		customer.setEmail(customerDetails.getEmail());
		customer.setPassword(customerDetails.getPassword());
		
		Customer updateCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updateCustomer);
		
	}
	
	//Delete  customer rest api
		@DeleteMapping("/customers/{id}")
		public ResponseEntity<Map<String,Boolean>> DeleteCustomer(@PathVariable Long id) {
			Customer customer = customerRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Customer not exist with id : "+ id));
			
			customerRepository.delete(customer);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
	
	
	
	
	
}

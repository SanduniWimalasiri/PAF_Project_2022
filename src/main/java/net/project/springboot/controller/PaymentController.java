package net.project.springboot.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import net.project.springboot.exception.ResourseNotFoundException;
import net.project.springboot.model.Payment;
import net.project.springboot.repository.PaymentRepository;

//import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class PaymentController {

	@Autowired
	private PaymentRepository paymentRepository;
	
	//get all employees
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return paymentRepository.findAll();
	}
	
	//get payment by id rest api
	@GetMapping("/payments/{id}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Payment Not Exist with ID :" + id));
		return ResponseEntity.ok(payment);
	}
	
	//update payment rest API
	@PutMapping("payments/{id}")
	public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails){
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Payment Not Exist with ID :" + id));
		payment.setBill_id(paymentDetails.getBill_id());
		payment.setCus_name(paymentDetails.getCus_name());
		payment.setEmial(paymentDetails.getEmail());
		payment.setArea_office(paymentDetails.getArea_office());
		payment.setCard_num(paymentDetails.getCard_num());
		payment.setAmount(paymentDetails.getAmount());
		
		Payment updatedPayment = paymentRepository.save(payment);
		return ResponseEntity.ok(updatedPayment);
	}
	
	//delete payment rest API
	@DeleteMapping("/payments/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePayment(@PathVariable Long id){
		Payment payment = paymentRepository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("Payment Not Exist with ID :" + id));
	paymentRepository.delete(payment);
	Map<String, Boolean> response = new HashMap<>();
	response.put("Deleted Successfully", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}
}
	
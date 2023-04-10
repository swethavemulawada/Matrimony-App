package com.matrimony.g.controller;

import java.util.List;




import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.g.entity.Payment;
import com.matrimony.g.service.PaymentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class PaymentController {
	
	
  private PaymentService paymentService;
	
	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}

	
		
	//http://localhost:2412/api/v1/payments
	@PostMapping("/payments")
	public ResponseEntity<Payment>addPayment(@Valid @RequestBody Payment payment) {
		return new ResponseEntity<Payment>(paymentService.addPayment(payment), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return paymentService.getAllPayments();
	}

	@GetMapping("/payments/{id}")
	public ResponseEntity<Payment> getPaymentById(@Valid @PathVariable("id") int paymentId){
		return new ResponseEntity<Payment>(paymentService.getPaymentById(paymentId), HttpStatus.OK);
		
	}

	@PutMapping("/payments/{id}")
	public ResponseEntity<Payment> updatePayment(@Valid @PathVariable("id")int id ,@RequestBody Payment payment){
		return new ResponseEntity<Payment>(paymentService.updatePayment(payment, id), HttpStatus.OK);
		
	}
}
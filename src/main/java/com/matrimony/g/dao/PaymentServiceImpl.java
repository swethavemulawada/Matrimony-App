 package com.matrimony.g.dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.g.entity.Payment;
import com.matrimony.g.exception.ResourceNotFoundException;
import com.matrimony.g.repository.PaymentRepository;
import com.matrimony.g.service.PaymentService;



@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
		private PaymentRepository paymentRepository;
		
		public PaymentServiceImpl(PaymentRepository paymentRepository) {
			super();
			this.paymentRepository = paymentRepository;
		}

                                                                                                 
		@Override 
		public Payment addPayment(Payment payment) {
			return paymentRepository.save(payment);
			
		}


		@Override
		public List<Payment>getAllPayments(){
			return paymentRepository.findAll();
		}
		
		
		@Override
		public Payment getPaymentById(int id) {
			
			return paymentRepository.findById(id).orElseThrow(() ->
new ResourceNotFoundException("Payment not found","Id",id));
				
			}


		@Override
		public Payment updatePayment(Payment payment, int id) { 
			Payment pay = paymentRepository.findById(id).orElseThrow(
					()-> new ResourceNotFoundException("Payment not found", "Id", id));

			pay.setCandidateName(payment.getCandidateName());
			pay.setBankName(payment.getBankName());
			pay.setAccountNo(payment.getAccountNo());
			pay.setIfscCode(payment.getIfscCode());
			
			
			paymentRepository.save(pay);
			return pay;
		}
		


	
}
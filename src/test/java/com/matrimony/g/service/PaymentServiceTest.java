package com.matrimony.g.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.matrimony.g.dao.PaymentServiceImpl;
import com.matrimony.g.entity.Payment;
import com.matrimony.g.repository.PaymentRepository;

public class PaymentServiceTest {

	@Mock
	private PaymentRepository paymentrepository;
	@InjectMocks
	private PaymentServiceImpl paymentservice;
	
	
	
	@ExtendWith
	(MockitoExtension.class)
	
	
	@Test
	public void testAddPayment() throws Exception{
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCandidateName("payment");
		payment.setBankName("bank");
		payment.setAccountNo("45645678");
		payment.setIfscCode("SBIH345345");
		payment.setAmount("1000");
		when(paymentrepository.save(payment)).thenReturn(payment);
		Payment savepayment = paymentservice.addPayment(payment);
		
		assertNotNull(savepayment);
		assertEquals("payment",savepayment.getCandidateName());
		}
	
	
	@Test
	public void testUpdatePayment() throws Exception{
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCandidateName("payment");
		payment.setBankName("bank");
		payment.setAccountNo("45645678");
		payment.setIfscCode("SBIH345345");
		payment.setAmount("1000");
		
		when(paymentrepository.findById(1)).thenReturn(Optional.of(payment));
		when(paymentrepository.save(payment)).thenReturn(payment);
	     Payment updatedpayment = paymentservice.updatePayment(payment, 1);

		 assertNotNull(updatedpayment);
	     assertEquals("payment",updatedpayment.getCandidateName());
		
	}
	/*@Test
	public void testGetPaymentById() throws Exception{
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCandidateName("payment");
		payment.setBankName("bank");
		payment.setAccountNo("45645678");
		payment.setIfscCode("SBIH345345");
		payment.setAmount("1000");
		
	}*/
	
	@Test
	public void testGetAllPayments(){
		Payment payment = new Payment();
		payment.setId(1);
		payment.setCandidateName("payment");
		payment.setBankName("bank");
		payment.setAccountNo("45645678");
		payment.setIfscCode("SBIH345345");
		payment.setAmount("1000");
		
		Payment payment1 = new Payment();
		payment1.setId(2);
		payment1.setCandidateName("name");
		payment1.setBankName("sbi");
		payment1.setAccountNo("987987987");
		payment1.setIfscCode("SBIH789789");
		payment1.setAmount("2000");
		
		
		List<Payment> pay = new ArrayList<Payment>();
		pay.add(payment);
		pay.add(payment1);
		
		when(paymentrepository.findAll()).thenReturn(pay);
		List<Payment> foundPaymentList = paymentservice.getAllPayments();
		assertNotNull(foundPaymentList);
		assertEquals(2,foundPaymentList.size());
		
		
	}
	 //get
	   @Test
	   @Order(2)
	    public void testReadAll() {
	        List<Payment> list = paymentrepository.findAll();
	        assertThat(list).size().isGreaterThan(0);
	    }


	// put

	/*   @Test
	    @Order(4)
	    public void testUpdate() {
	        Payment pay = paymentrepository.findById(2l).get();
	        pay.setCandidateName("anu");
	        paymentrepository.save(pay);
	        assertNotEquals("priya", paymentrepository.findById(2l).get().getName());
	    }
	*/
	
}

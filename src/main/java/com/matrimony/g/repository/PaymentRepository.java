package com.matrimony.g.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.matrimony.g.entity.Payment;


@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
	

}

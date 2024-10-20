package com.paymentService.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paymentService.app.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

package com.webarchitecture.assignment.payment.repository;

import com.webarchitecture.assignment.payment.model.PaymentInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentGatewayRepository {
    ResponseEntity<String> makePayment(PaymentInfo paymentInfo);
}

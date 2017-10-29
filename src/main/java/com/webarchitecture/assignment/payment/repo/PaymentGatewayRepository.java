package com.webarchitecture.assignment.payment.repo;

import com.webarchitecture.assignment.payment.model.PaymentInfo;
import org.springframework.http.ResponseEntity;

public interface PaymentGatewayRepository {
    ResponseEntity<String> makePayment(PaymentInfo paymentInfo);
}

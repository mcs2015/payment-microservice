package com.webarchitecture.assignment.payment.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository {
    void savePayment(String userId, String billId, double amount);
}

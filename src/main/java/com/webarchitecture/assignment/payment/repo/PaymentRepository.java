package com.webarchitecture.assignment.payment.repo;

public interface PaymentRepository {
    void savePayment(String userId, String billId, double amount);
}

package com.webarchitecture.assignment.payment.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
    private static Map<String, Map<String, Double>> payments = new HashMap<String, Map<String, Double>>();

    @Override
    public void savePayment(String userId, String billId, double amount) {
        if (payments.get(userId) == null) {
            Map<String, Double> bill = new HashMap<String, Double>();
            bill.put(billId, amount);
            payments.put(userId, bill);
        } else {
            payments.get(userId).put(billId, amount);
        }
    }
}

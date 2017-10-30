package com.webarchitecture.assignment.payment.repository;

import com.webarchitecture.assignment.payment.model.PaymentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PaymentGatewayRepositoryImpl implements PaymentGatewayRepository {

    @Autowired
    private RestTemplate restTemplate;

    private String serviceUrl;


    public PaymentGatewayRepositoryImpl(String serviceUrl) {
        this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
                : "http://" + serviceUrl;
    }

    @Override
    public ResponseEntity<String> makePayment(PaymentInfo paymentInfo) {
        return restTemplate.postForEntity(serviceUrl + "makepayment", paymentInfo, String.class);
    }

}

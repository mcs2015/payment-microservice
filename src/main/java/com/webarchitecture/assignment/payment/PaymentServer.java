package com.webarchitecture.assignment.payment;

import com.webarchitecture.assignment.payment.repo.PaymentGatewayRepository;
import com.webarchitecture.assignment.payment.repo.PaymentGatewayRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentServer {
    private static final String ACCOUNTS_SERVICE_URL = "http://PAYMENT-GATEWAY-SERVICE";

    public static void main(String[] args) {
        SpringApplication.run(PaymentServer.class, args);
    }

    @Bean
    public PaymentGatewayRepository paymentGatewayRepository(){
        return new PaymentGatewayRepositoryImpl(ACCOUNTS_SERVICE_URL);
    }
}

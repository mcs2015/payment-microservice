package com.webarchitecture.assignment.payment;

import com.webarchitecture.assignment.payment.repository.PaymentGatewayRepository;
import com.webarchitecture.assignment.payment.repository.PaymentGatewayRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication {
    private static final String ACCOUNTS_SERVICE_URL = "http://PAYMENT-GATEWAY-SERVICE";

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication.class, args);
    }

    @Bean
    public PaymentGatewayRepository paymentGatewayRepository(){
        return new PaymentGatewayRepositoryImpl(ACCOUNTS_SERVICE_URL);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

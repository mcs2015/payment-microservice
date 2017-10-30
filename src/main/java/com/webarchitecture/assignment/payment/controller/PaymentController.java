package com.webarchitecture.assignment.payment.controller;

import com.webarchitecture.assignment.payment.model.CreditCard;
import com.webarchitecture.assignment.payment.model.PaymentInfo;
import com.webarchitecture.assignment.payment.model.PaymentRequest;
import com.webarchitecture.assignment.payment.repository.PaymentGatewayRepository;
import com.webarchitecture.assignment.payment.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;

    @Autowired
    private PaymentGatewayRepository pgRepository;

    private static final CreditCard DEFAULT_CREDIT_CARD = new CreditCard("4111111111111111", 123);

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity payBill(@RequestBody PaymentRequest paymentRequest) {
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setAmount(paymentRequest.getAmount());
        paymentInfo.setCreditCardNumber(paymentRequest.getCreditCard() == null ? DEFAULT_CREDIT_CARD.getCreditCardNumber() :
                paymentRequest.getCreditCard().getCreditCardNumber());
        paymentInfo.setCvv(paymentRequest.getCreditCard() == null ? DEFAULT_CREDIT_CARD.getCvv() :
                paymentRequest.getCreditCard().getCvv());
        ResponseEntity<String> responseEntity = pgRepository.makePayment(paymentInfo);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            repository.savePayment(paymentRequest.getUserId(), paymentRequest.getBillId(), paymentRequest.getAmount());
        }
        return responseEntity;
    }
}

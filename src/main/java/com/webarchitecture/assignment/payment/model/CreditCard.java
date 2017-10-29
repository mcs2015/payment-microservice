package com.webarchitecture.assignment.payment.model;

public class CreditCard {
    private String creditCardNumber;
    private int cvv;

    public CreditCard(String creditCardNumber, int cvv) {
        this.creditCardNumber = creditCardNumber;
        this.cvv = cvv;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}

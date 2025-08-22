package com.seiryu.ecommerce.backend_ecommerce.domain.model;

import lombok.Data;

@Data
public class DataPayment {

    private String method;
    private String amount;
    private String currency;
    private String description;

    public DataPayment() {
    }

    public DataPayment(String method, String amount, String currency, String description) {
        this.method = method;
        this.amount = amount;
        this.currency = currency;
        this.description = description;
    }

    @Override
    public String toString() {
        return "DataPayment [method=" + method + ", amount=" + amount + ", currency=" + currency + ", description="
                + description + "]";
    }

}

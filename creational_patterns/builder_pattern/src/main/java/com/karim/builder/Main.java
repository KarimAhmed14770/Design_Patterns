package com.karim.builder;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){


        FinancialTransaction transaction=FinancialTransaction.builder()
                .withTransactionId("123")
                .withDestinationAccountId("321")
                .withSourceAccountId("333").withAmount(BigDecimal.valueOf(1000))
                .build();
        System.out.println(transaction);
    }
}

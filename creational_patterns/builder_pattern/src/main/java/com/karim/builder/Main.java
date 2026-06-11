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

        MessageBuilder smsMessageBuilder=new SmsMessageBuilder();
        AlertMessage message1=smsMessageBuilder.withHeader("Warn\n").
        withBody("password needs to be changed\n").withFooter("urgent").build();

        MessageBuilder htmlMessageBuilder=new HtmlMessageBuilder();
        AlertMessage message2=htmlMessageBuilder.withHeader("error").withBody("change password")
                .withFooter("timestamp").build();

        System.out.println(message1);
        System.out.println(message2);


    }
}

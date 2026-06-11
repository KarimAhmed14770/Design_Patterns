package com.karim.builder;

public class SmsMessageBuilder implements MessageBuilder{
   private StringBuilder smsMessage=new StringBuilder();

    @Override
    public MessageBuilder withHeader(String header) {
        smsMessage.append("Alert Type: ").append(header).append("\n");
        return this;
    }

    @Override
    public MessageBuilder withBody(String body) {
        smsMessage.append("Body: ").append(body).append("\n)");
        return this;
    }

    @Override
    public MessageBuilder withFooter(String footer) {
        smsMessage.append("Footer: ").append(footer).append("\n");
        return this;
    }


    @Override
    public AlertMessage build() {
        return new AlertMessage(smsMessage.toString());
    }
}

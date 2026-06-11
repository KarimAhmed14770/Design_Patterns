package com.karim.builder;

public interface MessageBuilder {
    MessageBuilder withHeader(String header);
    MessageBuilder withBody(String body);
    MessageBuilder withFooter(String footer);
    AlertMessage build();
}

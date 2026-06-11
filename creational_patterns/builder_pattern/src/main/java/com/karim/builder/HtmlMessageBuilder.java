package com.karim.builder;

public class HtmlMessageBuilder implements MessageBuilder{
    private StringBuilder htmlMessage=new StringBuilder();
    @Override
    public MessageBuilder withHeader(String header) {
        htmlMessage.append("<h1> ").append(header).append("</h1>\n");
        return this;
    }

    @Override
    public MessageBuilder withBody(String body) {
        htmlMessage.append("<p> Body: ").append(body).append("</p>\n");
        return this;
    }

    @Override
    public MessageBuilder withFooter(String footer) {
        htmlMessage.append("<footer> ").append(footer).append("</footer>\n");
        return this;
    }

    @Override
    public AlertMessage build() {
        return new AlertMessage(htmlMessage.toString());
    }
}

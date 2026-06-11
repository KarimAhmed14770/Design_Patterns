package com.karim.builder;

public class AlertMessage {
    private final String content;

    AlertMessage(String content){
        this.content=content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "AlertMessage{" +
                "content= " + content + '\'' +
                '}';
    }
}

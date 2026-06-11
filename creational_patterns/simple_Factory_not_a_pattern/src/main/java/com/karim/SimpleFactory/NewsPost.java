package com.karim.SimpleFactory;

import java.math.BigDecimal;

public class NewsPost extends Post{
    private String source;

    public NewsPost(String title, String content, String source){
        super(title,content);
        this.source=source;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}

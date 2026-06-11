package com.karim.SimpleFactory;

import java.math.BigDecimal;

public class BlogPost extends Post{
    private String author;

    public BlogPost(String title, String content, String author){
        super(title,content);
        this.author=author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

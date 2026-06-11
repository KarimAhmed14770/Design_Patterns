package com.karim.SimpleFactory;

import java.math.BigDecimal;

public class PostFactory {
    public static Post createPost(String PostChoice,String title, String content, String extraAttribute){
        switch (PostChoice){
            case "Blog"-> {
                return new BlogPost(title,content,extraAttribute);
            }
            case "News"-> {
                return new NewsPost(title,content,extraAttribute);
            }
            case "Product"-> {
                return new ProductPost(title,content, new BigDecimal(extraAttribute));
            }
            default -> {
                throw new IllegalArgumentException("illegal input");
            }
        }
    }
}

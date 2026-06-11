package com.karim.SimpleFactory;

import java.math.BigDecimal;

public class ProductPost extends Post{
    private BigDecimal price;

    public ProductPost(String title, String content, BigDecimal price){
        super(title,content);
        this.price=price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

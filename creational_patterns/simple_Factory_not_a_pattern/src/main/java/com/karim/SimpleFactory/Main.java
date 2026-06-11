package com.karim.SimpleFactory;

public class Main {
    public static void main(String[] args){

        System.out.println(PostFactory.createPost("Blog","first","xxx","yyy"));
        System.out.println(PostFactory.createPost("News","first","xxx","yyy"));
        System.out.println(PostFactory.createPost("Product","first","xxx","98.2"));

    }
}

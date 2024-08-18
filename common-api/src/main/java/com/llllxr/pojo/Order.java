package com.llllxr.pojo;
@lombok.Data
public class Order {
    private int id;
    private String name;
    private String price;
    private int userId;
    private User user;
}

package com.interns.simpleApp.model;

public class Product {
    private String name;
    private ProductType typ;
    private float price;
    private int id;


    private static int productId;

    public Product(String name, ProductType typ, float price) {
        this.name = name;
        this.typ = typ;
        this.price = price;
        id = ++productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getTyp() {
        return typ;
    }

    public void setTyp(ProductType typ) {
        this.typ = typ;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

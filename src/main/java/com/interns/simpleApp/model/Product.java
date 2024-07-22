package com.interns.simpleApp.model;

public class Product {
    String name;
    String typ; // später enum erstellen
    float price;
    int amount;

    public Product(String name, String typ, float price, int amount) {
        this.name = name;
        this.typ = typ;
        this.price = price;
        this.amount = amount;
    }


}

package com.interns.simpleApp.model;
import java.util.ArrayList;

public class Basket {
    ArrayList<Product> items;

    public Basket(ArrayList<Product> items) {
        this.items =items;
    }

    public ArrayList<Product> getItems() {
        return items;
    }

    public void setItems(ArrayList<Product> items) {
        this.items = items;
    }

    public int amountOfProducts() {
        return items.size();
    }

    public float subtotal() {
        float subtotal = 0.0f;
        for (int i = 0; i < items.size(); i++) {
            subtotal += items.get(i).getPrice();
        }
        return subtotal;
    }
    public float finalPrice() {
        return subtotal() + 4.90f; // delivery
    }
    public void addToBasket(Product product) {
        items.add(items.size()-1,product);
    }
}

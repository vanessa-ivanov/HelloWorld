package com.interns.simpleApp.model;
import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> items = new ArrayList<>();

    /*
    public Basket(ArrayList<Product> items) {
        this.items =items;
    }
     */

    public List<Product> getItems() {
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
        items.add(product);
    }

    public void printBasket() {
        System.out.println("Items in basket");
        if (items.size() == 0) {
            System.out.println("Basket is empty");
        } else {
            for (int i = 0; i < items.size(); i++) {
                System.out.println(items.get(i).getName());
            }
        }
    }
}

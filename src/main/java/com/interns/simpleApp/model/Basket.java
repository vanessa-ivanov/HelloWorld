package com.interns.simpleApp.model;

public class Basket {
    private int amount;
    private Product product;

    public Basket(int amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float subtotal() {
        return amount* product.getPrice();
    }
    public float finalPrice() {
        return subtotal() + 4.90f; // delivery
    }
}

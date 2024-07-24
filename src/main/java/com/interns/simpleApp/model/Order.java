package com.interns.simpleApp.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private User user;
    private List<Product> items = new ArrayList<>();
    private String address;
    private String deliveryKind; // fast or normal
    private LocalDate date;
    private String cardCredentials;

    public Order(User user, List<Product> items, String address, String deliveryKind, LocalDate date, String cardCredentials) {
        this.user = user;
        this.items = items;
        this.address = address;
        this.deliveryKind = deliveryKind;
        this.date = date;
        this.cardCredentials = cardCredentials;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDeliveryKind() {
        return deliveryKind;
    }

    public void setDeliveryKind(String deliveryKind) {
        this.deliveryKind = deliveryKind;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCardCredentials() {
        return cardCredentials;
    }

    public void setCardCredentials(String cardCredentials) {
        this.cardCredentials = cardCredentials;
    }
}


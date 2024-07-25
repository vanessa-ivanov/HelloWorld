package com.interns.simpleApp.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private User user;
    private Basket basket;
    private String address;
    private String deliveryKind; // fast or normal
    private LocalDate date;
    private String cardCredentials;

    public Order(User user, Basket basket, String address, String deliveryKind, LocalDate date, String cardCredentials) {
        this.user = user;
        this.basket = basket;
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

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
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

    public float endPrice() {
        if (deliveryKind.equals("fast")) {
            return basket.subtotal() + 4.90f; // pay extra for fast delivery
        }
        return basket.subtotal();
    }

    public LocalDate deliveryTime() {
        if (deliveryKind.equals("fast")) {
            return date.plusDays(2);
        }
        return date.plusDays(7);
    }

    public int deliveryDuration() {
        Period period = Period.between(date, deliveryTime());
        return period.getDays() +1;
    }

}


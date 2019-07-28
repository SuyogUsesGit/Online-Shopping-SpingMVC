package com.suyoggaikwad.model;

public class Item {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private int quantityEntered;
    private double priceIncurred;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantityEntered() {
        return quantityEntered;
    }

    public void setQuantityEntered(int quantityEntered) {
        this.quantityEntered = quantityEntered;
    }

    public double getPriceIncurred() {
        return priceIncurred;
    }

    public void setPriceIncurred(double priceIncurred) {
        this.priceIncurred = priceIncurred;
    }
}

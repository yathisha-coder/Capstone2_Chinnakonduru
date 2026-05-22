package org.example;

public abstract class MenuItem {
    protected String name;
    //Method for calculate the price
    public abstract double calculatePrice();
    //Method for receipt
    public abstract String getReceiptText();
}

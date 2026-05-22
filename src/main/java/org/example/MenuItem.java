package org.example;

public abstract class MenuItem {
    protected String name;
    //Constructor
    public MenuItem(String name){
        this.name = name;
    }
    //Getter
    public  String  getName(){
        return name;
    }
    //Method for calculate the price
    public abstract double calculatePrice();
    //Method for receipt
    public abstract String getReceiptText();
}

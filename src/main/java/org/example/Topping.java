package org.example;

public class Topping extends MenuItem {
    //Meat, Cheese, regular, sauce
    private ToppingType type;
    //Constructor
    public Topping(String name) {
        super(name);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    public double calculatePrice(PizzaSize size) {
        double price = 0;
        return price;
    }

    @Override
    public String getReceiptText() {
        return "";
    }
}

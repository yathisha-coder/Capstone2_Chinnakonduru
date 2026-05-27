package org.example;

public class GarlicKnots extends MenuItem {
    //property
    private double price;
    //Constructor
    public GarlicKnots() {
        super("GarlicKnots");
        this.price = 1.50;
    }
    //Getter
    public double getPrice() {
        return price;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String getReceiptText() {
        return "=====GARLIC KNOTS=====\n" +
                "Price: $%.2f".formatted(price);
    }
}

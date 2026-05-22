package org.example;

public class Pizza extends MenuItem {
    private PizzaSize size;
    private CrustType crust;
    private boolean stuffedCrust;

    public Pizza(String name) {
        super(name);
    }

    @Override
    public double calculatePrice() {
        return 0;
    }

    @Override
    public String getReceiptText() {
        return "";
    }
}

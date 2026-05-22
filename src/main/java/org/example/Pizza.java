package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends MenuItem {
    private PizzaSize size;
    private CrustType crust;
    private boolean stuffedCrust;

    //Lists to store pizza ingredients
    private List<String> meats = new ArrayList<>();
    private List<String> cheeses = new ArrayList<>();
    private List<String> regularTopping = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();
    //Constructor
    public Pizza(String name,PizzaSize size,CrustType crust,boolean stuffedCrust) {
        super(name);
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
    }
    //Add Toppings methods
    public void addMeat(String meat){
        meats.add(meat);
    }
    public void addCheese(String cheese){
        cheeses.add(cheese);
    }
    public void addRegularTopping(String topping){
        regularTopping.add(topping);
    }
    public void addSauce(String sauce){
        sauces.add(sauce);
    }
    @Override
    public double calculatePrice() {
        double price = 0;
        switch (size){
            case PERSONAL -> price = 8.50;
            case MEDIUM ->  price = 12.00;
            case LARGE -> price = 16.50;
        }
        //Ternary Operator
        String crustText = stuffedCrust ? "Yes" : "No";
        return price;
    }

    @Override
    public String getReceiptText() {
        return "======PIZZA======" +
                "Name: " + name + "\\n" +
                "Size: " + size + "\\n" +
                "Crust: " + crust + "\\n" +
                "Stuffed Crust: " +
                (stuffedCrust ? "Yes" : "No") + "\\n" +
                "Price: $" +
                String.format("%.2f", calculatePrice()) + "\\n";
    }
}

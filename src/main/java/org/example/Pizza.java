package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pizza extends MenuItem {
    private PizzaSize size;
    private CrustType crust;
    private boolean stuffedCrust;

    //Lists to store pizza ingredients
    private List<Topping> toppings = new ArrayList<>();
    //Constructor
    public Pizza(String name,PizzaSize size,CrustType crust,boolean stuffedCrust){
        super(name);
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
    }
    //Add Toppings methods
    public void addTopping(Topping topping){
        toppings.add(topping);
    }
    @Override
    public double calculatePrice() {
        double total = size.getBasePrice();
      //Stream adds all topping prices
        total += toppings.stream()
                .mapToDouble(topping ->
                        topping.calculatePrice(size))
                .sum();
        //Stuffed crust extra cost
        if(stuffedCrust){
            total += 2.00;
        }
        return total;
    }

    @Override
    public String getReceiptText() {
        StringBuilder sb = new StringBuilder();
        sb.append("====== PIZZA ======\n");
        sb.append("Name: ")
                .append(name)
                .append("\n");
        sb.append("Size: ")
                .append(size)
                .append("\n");
        sb.append("Crust: ")
                .append(crust)
                .append("\n");
        sb.append("Stuffed Crust: ")
                .append(stuffedCrust ? "Yes" : "No")
                .append("\n");
        // TOPPINGS
        if (!toppings.isEmpty()) {
            sb.append("\nToppings:\n");
            for (Topping topping : toppings) {
                sb.append("- ")
                        .append(topping.getName())
                        .append("\n");
            }
        }
        sb.append("\nPrice: $")
                .append(String.format("%.2f",calculatePrice()))
                .append("\n");
        return sb.toString();
    }
}

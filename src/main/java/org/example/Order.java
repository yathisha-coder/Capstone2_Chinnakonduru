package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items = new ArrayList<>();
    //Add normal item(pizza, drink)
    public void addItem(MenuItem item){
         items.add(0,item);
    }
    //Garlic Knots quantity
    public void addGarlicKnots(int quantity){
        for (int i = 0; i < quantity; i++){
            items.add(0,new GarlicKnots());
        }
    }
    //Total Calculated using spring
    public double calculateTotal(){
        return items.stream()
                .mapToDouble(MenuItem :: calculatePrice)
                .sum();
    }
    //Receipt Method
    public String getReceiptText(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n======ORDER======");
        items.stream()
                .map(MenuItem :: getReceiptText)
                .forEach(sb::append);
        sb.append("-----------------------------\n");
        sb.append("TOTAL: $")
                .append(String.format("%.2f", calculateTotal()));
        return sb.toString();
    }
}

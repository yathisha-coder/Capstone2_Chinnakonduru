package org.example;

import de.vandermeer.asciitable.AsciiTable;

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
    public boolean isEmpty(){
        return items.isEmpty();
    }
    //Total Calculated using spring
    public double calculateTotal(){
        return items.stream()
                .mapToDouble(MenuItem :: calculatePrice)
                .sum();
    }
    //Receipt Method
    public String getReceiptText() {
        AsciiTable table = new AsciiTable();
        // Top Border
        table.addRule();
        // Header
        table.addRow("ITEM", "PRICE");
        table.addRule();
        // Add items
        items.forEach(item -> {
            table.addRow(item.getName(), "$" + String.format("%.2f", item.calculatePrice()));
            table.addRule();
        });
        //TOTAL ONLY ONCE
        table.addRow("TOTAL", "$" + String.format("%.2f", calculateTotal())
        );
        table.addRule();
        return table.render();
    }
}

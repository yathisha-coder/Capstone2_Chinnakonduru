package org.example;

public class Drink extends MenuItem {
    private DrinkSize size;
    private String flavor;
    //Constructor
    public Drink(String name, DrinkSize size, String flavor){
        super(name);
        this.size = size;
        this.flavor = flavor;
    }
    @Override
    public double calculatePrice() {
        double price =0;
        switch (size){
            case SMALL -> price = 2.00;
            case MEDIUM -> price = 2.50;
            case LARGE -> price = 3.00;
        }
        return price;
    }

    @Override
    public String getReceiptText() {
        return "=====DRINK======\n" +
                "Flavor: " + flavor + "\n" +
                "Size: " + size + "\n" +
                "Price: $" +
                String.format("%.2f", calculatePrice()) +
                "\n";
    }
}

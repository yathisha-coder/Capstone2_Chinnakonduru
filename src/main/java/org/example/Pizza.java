package org.example;

public class Pizza extends MenuItem {
    private PizzaSize size;
    private CrustType crust;
    private boolean stuffedCrust;

    public Pizza(String name,PizzaSize size,CrustType crust,boolean stuffedCrust) {
        super(name);
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
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

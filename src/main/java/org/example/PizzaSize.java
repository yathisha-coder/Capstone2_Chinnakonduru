package org.example;

public enum PizzaSize {
    PERSONAL(8.50),
    MEDIUM(12.00),
    LARGE(16.50);
    //Base Pizza Price
    private double basePrice;

    //Constructor
    PizzaSize(double basePrice){
        this.basePrice = basePrice;
    }

    //Getter
    public double getBasePrice(){
        return  basePrice;
    }

}

package org.example;

import static org.example.CrustType.REGULAR;
import static org.example.ToppingType.SAUCE;

public class Topping {
    private String name;
    //Meat, Cheese, regular, sauce
    private ToppingType type;
    private boolean extra;
    //Constructor
    public Topping(String name,ToppingType type, boolean extra) {
            this.name = name;
            this.type = type;
            this.extra = extra;
    }
    //Getters
    public String getName(){
        return name;
    }
    public ToppingType getType(){
        return type;
    }
    public boolean isExtra(){
        return extra;
    }
    //Topping price depends on pizza size
    public double calculatePrice(PizzaSize size) {
        double price = 0;
        switch (type){
            case MEAT -> {
                switch (size) {
                    case PERSONAL -> price = 1.00;
                    case MEDIUM -> price = 2.00;
                    case LARGE -> price = 3.00;
                }
                if (extra) {
                    switch (size) {
                        case PERSONAL -> price += 0.50;
                        case MEDIUM -> price += 1.00;
                        case LARGE -> price += 1.50;
                    }
                }
            }
            case CHEESE -> {
                switch (size){
                    case PERSONAL -> price = 0.75;
                    case MEDIUM-> price = 1.50;
                    case LARGE -> price = 2.25;
                }
                if(extra){
                    switch (size){
                        case PERSONAL -> price += 0.30;
                        case MEDIUM -> price += 0.60;
                        case LARGE -> price += 0.90;
                    }
                }
            }
            case REGULAR -> price = 0.0;
            case SAUCE -> price = 0.0;
        }
        return price;
    }
}

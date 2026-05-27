package org.example;

public class VeggiePizza extends Pizza{
    public VeggiePizza() {
        super("Veggie Pizza", PizzaSize.PERSONAL, CrustType.REGULAR, false);
        //Add Toppings
        addTopping(new Topping("Bell Peppers",ToppingType.REGULAR,false));
        addTopping(new Topping("Spinach",ToppingType.CHEESE,true));
        addTopping(new Topping("Olives",ToppingType.REGULAR,false));
    }
}

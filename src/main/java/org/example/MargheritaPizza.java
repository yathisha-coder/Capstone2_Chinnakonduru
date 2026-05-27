package org.example;

public class MargheritaPizza extends Pizza{
    public MargheritaPizza() {
        super("Margherita Pizza", PizzaSize.MEDIUM, CrustType.REGULAR,false);
        //Add toppings
        addTopping(new Topping("Basil", ToppingType.CHEESE,true));
        addTopping(new Topping("Tomatoes",ToppingType.REGULAR,true));
        addTopping(new Topping("Olive Oil",ToppingType.REGULAR,false));
    }
}

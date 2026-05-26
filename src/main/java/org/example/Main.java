package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        homeScreen(scanner);
    }
    public static void homeScreen(Scanner scanner){
        while (true){
            System.out.println("======HOME SCREEN=======");
            System.out.println("1. New Order");
            System.out.println("0. Exit");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    orderScreen(scanner);
                break;
                case 0:
                    System.out.println("Thank You for shopping! Please come again!");
                    return;
                default:
                    System.out.println("Invalid Option.");
            }
        }
    }
    public static void orderScreen(Scanner scanner){
        Order order = new Order();
        while (true){
            System.out.println("=====ORDER SCREEN=====");
            System.out.println("1.Add Pizza");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Garlic Knots");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");
            System.out.println("99. Exit");
            int option = Integer.parseInt(scanner.nextLine());
            switch (option){
                case 1:
                    order.addItem(addPizza(scanner));
                    System.out.println("Pizza Added!");
                    break;
                case 2:
                    order.addItem(addDrink(scanner));
                    System.out.println("Drink Added!");
                    break;
                case 3:
                    System.out.println("Enter Quantity: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    order.addGarlicKnots(quantity);
                    System.out.println("Garlic Knots Added!");
                    break;
                case 4:
                    checkOut(scanner,order);
                    System.out.println("You're Order successfully checkout");
                    break;
                case 0:
                    System.out.println("Order Cancelled.");
                    break;
                case 99:
                    return;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }
    public static Pizza addPizza(Scanner scanner) {
        System.out.println("\nSelect Pizza Size");
        System.out.println("1. PERSONAL");
        System.out.println("2. MEDIUM");
        System.out.println("3. LARGE");
        int sizeOption = Integer.parseInt(scanner.nextLine());
        PizzaSize size;
        switch (sizeOption) {
            case 1:
                size = PizzaSize.PERSONAL;
                break;
            case 2:
                size = PizzaSize.MEDIUM;
                break;
            default:
                size = PizzaSize.LARGE;
        }

        //CRUST
        System.out.println("\nSelect Crust Type");
        System.out.println("1. THIN");
        System.out.println("2. REGULAR");
        System.out.println("3. THICK");
        System.out.println("4. CAULIFLOWER");
        int crustOption = Integer.parseInt(scanner.nextLine());
        CrustType crustType;
        switch (crustOption) {
            case 1:
                crustType = CrustType.THIN;
                break;
            case 2:
                crustType = CrustType.REGULAR;
                break;
            case 3:
                crustType = CrustType.THICK;
                break;
            default:
                crustType = CrustType.CAULIFLOWER;
        }
        //STUFFED CRUST
        boolean stuffedCrust = false;
        while (true) {
            System.out.println("Stuffed crust? (y/n)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")){
                stuffedCrust = true;
                break;
            }
            else if (input.equalsIgnoreCase("n")) {
                 stuffedCrust = false;
                break;
            }
            else {
                System.out.println("Invalid input. Please enter y or n.");
            }
        }
        //CREATE PIZZA
        Pizza pizza = new Pizza("Custom Pizza",size, crustType,stuffedCrust);

        //TOPPINGS
        while (true) {
            System.out.println("\n===== TOPPINGS =====");
            System.out.println("1. Pepperoni(MEAT)");
            System.out.println("2. Sausage");
            System.out.println("3. Mozzarella(CHEESE)");
            System.out.println("4. Mushrooms(OTHER)");
            System.out.println("5. Onion (OTHER)");
            System.out.println("0. Done");
            int toppingOption = Integer.parseInt(scanner.nextLine());
            switch (toppingOption) {
                case 1:
                    pizza.addTopping(new Topping("Pepperoni", ToppingType.MEAT, true));
                    break;
                case 2:
                    pizza.addTopping(new Topping("Sausage", ToppingType.MEAT, false));
                    break;
                case 3:
                    pizza.addTopping(new Topping("Mozzarella", ToppingType.CHEESE, true));
                    break;
                case 4:
                    pizza.addTopping(new Topping("Mushrooms", ToppingType.REGULAR, true));
                    break;
                case 5:
                    pizza.addTopping(new Topping("Onion",ToppingType.REGULAR,true));
                case 0:
                    break;
                default:
                    System.out.println("Invalid Option.");
            }
            return pizza;
        }
    }
    public static Drink addDrink(Scanner scanner){
        System.out.println("\nSelect Drink Size");
        System.out.println("1. SMALL");
        System.out.println("2. MEDIUM");
        System.out.println("3. LARGE");
        int sizeOption = Integer.parseInt(scanner.nextLine());
        DrinkSize size;
        switch (sizeOption){
            case 1:
                size = DrinkSize.SMALL;
                break;
            case  2:
                size = DrinkSize.MEDIUM;
                break;
            default:
                size = DrinkSize.LARGE;
        }
        System.out.println("Enter flavor:");
        String flavor = scanner.nextLine();
        return new Drink("Drink", size, flavor);
    }
    public static void checkOut(Scanner scanner,Order order){
        if (order.isEmpty()){
            System.out.println("Order cannot be empty.");
            return;
        }
        System.out.println(order.getReceiptText());
        System.out.println("\n 1.Confirm");
        System.out.println("0. Cancel");
        int option = Integer.parseInt(scanner.nextLine());
        if(option==1){
            System.out.println("Order Confirmed!");
        }else {
            System.out.println("Order Cancelled.");
        }

    }
}
package org.example;

import java.util.Scanner;

public class Main {
    public static final String RESET ="\u001B[0m";
    public static final String GREEN ="\u001B[32m";
    public static final String YELLOW ="\u001B[33m";
    public static final String BLUE ="\u001B[34m";
    public static final String PURPLE ="\u001B[35m";
    public static final String PINK ="\u001B[95m";
    public static final String RED = "\u001B[31m";
    public static final String CYAN = "\u001B[36m";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        homeScreen(scanner);
    }
    public static void homeScreen(Scanner scanner){
        while (true){
            System.out.println(YELLOW + "\n======WELCOME TO PIZZA WORLD=======\n\n" + RESET);
            System.out.println(PINK + "======HOME SCREEN=======" +RESET);
            System.out.println(GREEN + "1. New Order" +RESET);
            System.out.println(GREEN + "0. Exit" + RESET);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    orderScreen(scanner);
                break;
                case 0:
                    System.out.println(YELLOW + "Thank You for shopping! Please come again!" + RESET);
                    return;
                default:
                    System.out.println(RED + "Invalid Option." + RESET);
            }
        }
    }
    public static void orderScreen(Scanner scanner){
        Order order = new Order();
        while (true){
            System.out.println(BLUE + "=====ORDER SCREEN=====" + RESET);
            System.out.println(PURPLE + "1. Add Custom Pizza" + RESET);
            System.out.println(PURPLE + "2. Add Signature Pizza" + RESET);
            System.out.println(PURPLE + "3. Add Drink" + RESET);
            System.out.println(PURPLE + "4. Add Garlic Knots" + RESET);
            System.out.println(PURPLE + "5. Checkout" + RESET);
            System.out.println(PURPLE + "0. Cancel Order" + RESET);
            System.out.println(PURPLE + "99. Exit" + RESET);
            int option = Integer.parseInt(scanner.nextLine());
            switch (option){
                case 1:
                    order.addItem(addPizza(scanner));
                    System.out.println(PINK + "Custom Pizza Added!" + RESET );
                    break;
                case 2:
                    Pizza signaturePizza = addSignaturePizza(scanner);
                    if(signaturePizza != null){
                        order.addItem(signaturePizza);
                        System.out.println(PURPLE + "Signature Pizza Added!" + RESET);
                    }
                    break;
                case 3:
                    order.addItem(addDrink(scanner));
                    System.out.println(BLUE + "Drink Added!" + RESET);
                    break;
                case 4:
                    System.out.println(GREEN + "Enter Quantity: " + RESET);
                    int quantity = Integer.parseInt(scanner.nextLine());
                    order.addGarlicKnots(quantity);
                    System.out.println(PINK + "Garlic Knots Added!" + RESET);
                    break;
                case 5:
                    checkOut(scanner,order);
                    System.out.println(YELLOW + "You're Order successfully checkout" + RESET);
                    //Reset order
                    order = new Order();
                    System.out.println(CYAN + "New order started." + RESET);
                    break;
                case 0:
                    System.out.println(YELLOW + "Order Cancelled." + RESET);
                    break;
                case 99:
                    return;
                default:
                    System.out.println(RED + "Invalid Option" + RESET);
            }
        }
    }
    public static Pizza addPizza(Scanner scanner) {
        System.out.println(GREEN + "\nSelect Pizza Size" + RESET);
        System.out.println(BLUE + "1. PERSONAL" + RESET);
        System.out.println(BLUE + "2. MEDIUM" + RESET);
        System.out.println(BLUE + "3. LARGE" + RESET);
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
        System.out.println(YELLOW + "\nSelect Crust Type" + RESET);
        System.out.println(PINK + "1. THIN" + RESET);
        System.out.println(PINK + "2. REGULAR" + RESET);
        System.out.println(PINK + "3. THICK" + RESET);
        System.out.println(PINK + "4. CAULIFLOWER" + RESET);
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
            System.out.println(CYAN + "\n===== TOPPINGS =====" + RESET);
            System.out.println(YELLOW + "1. Pepperoni(MEAT)" + RESET);
            System.out.println(YELLOW + "2. Sausage" + RESET);
            System.out.println(YELLOW + "3. Mozzarella(CHEESE)" + RESET);
            System.out.println(YELLOW + "4. Mushrooms(OTHER)" + RESET);
            System.out.println(YELLOW + "5. Onion (OTHER)" + RESET);
            System.out.println(YELLOW + "0. Done" + RESET);
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
                    System.out.println(RED + "Invalid Option." + RESET);
            }
            return pizza;
        }
    }
    public static Drink addDrink(Scanner scanner){
        System.out.println(CYAN + "\nSelect Drink Size" + RESET);
        System.out.println(GREEN + "1. SMALL" + RESET);
        System.out.println(GREEN + "2. MEDIUM" + RESET);
        System.out.println(GREEN + "3. LARGE" + RESET);
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
        System.out.println(PURPLE + "Enter flavor:" + RESET);
        String flavor = scanner.nextLine();
        return new Drink("Drink", size, flavor);
    }
    public static void checkOut(Scanner scanner,Order order){
        if (order.isEmpty()){
            System.out.println("Order cannot be empty.");
            return;
        }
        System.out.println(YELLOW + "1.Confirm" + RESET);
        System.out.println(YELLOW + "0. Cancel" + RESET);
        int option = Integer.parseInt(scanner.nextLine());
        if(option==1){
            ReceiptManager.saveReceipt(order);
            System.out.println(CYAN + "Order Confirmed!" + RESET);
        }else {
            System.out.println(PURPLE + "Order Cancelled." + RESET);
        }
        System.out.println(order.getReceiptText());
        double total = order.calculateTotal();
        System.out.println("\nTOTAL: $" + String.format("%.2f",total));
        //Payment menu
        System.out.println(BLUE + "\n=====PAYMENT=====" + RESET);
        System.out.println(YELLOW + "1. Cash" + RESET);
        System.out.println(YELLOW + "2. Card" + RESET);
        System.out.println(YELLOW + "0. Cancel" + RESET);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            //Cash
            case 1:
               System.out.println(PINK + "Enter Cash amount: " + RESET);
               double cash = Double.parseDouble(scanner.nextLine());
               if(cash < total){
                   System.out.println(RED + "Not Enough Cash" + RESET);
                   return;
               }
               double change = cash - total;
                System.out.println("Change: $" + String.format("%.2f",change));
                ReceiptManager.saveReceipt(order);
                System.out.println(CYAN + "Payment Successful!" + RESET);
                //Show the receipt
                System.out.println(BLUE + "\n====YOUR RECEIPT====" + RESET);
                System.out.println(order.getReceiptText());
               break;
               //Card
            case 2:
                System.out.println(YELLOW + "\n====CARD TYPE====" + RESET);
                System.out.println(PINK + "1. Debit Card" + RESET);
                System.out.println(PINK + "2. Credit Card" + RESET);
                int cardOption = Integer.parseInt(scanner.nextLine());
                //Debit card
                if(cardOption ==1) {
                    System.out.println(BLUE + "Enter Debit Card Number: " + RESET);
                    String debitCard = scanner.nextLine();
                    System.out.println(PURPLE + "Enter PIN: " + RESET);
                    String pin = scanner.nextLine();
                    System.out.println(CYAN + "Processing Card Payment...." + RESET);
                    System.out.println(GREEN + "Payment Successful!" + RESET);
                    //Shows the receipt
                    System.out.println(YELLOW + "\n====YOUR RECEIPT====" + RESET);
                    System.out.println(order.getReceiptText());
                } else if(cardOption ==2) {
                    System.out.println(BLUE + "Enter Credit Card Number:" + RESET);
                    String creditCard = scanner.nextLine();
                    System.out.println(PINK + "Processing Credit Payment....." + RESET);
                    System.out.println(PURPLE + "Payment Successful!" + RESET);
                    //shows the receipt
                    System.out.println(CYAN + "\n====YOUR RECEIPT====" + RESET);
                    System.out.println(order.getReceiptText());
                }else {
                    System.out.println(RED + "Invalid Card Option" + RESET);
                    return;
                }
                ReceiptManager.saveReceipt(order);
                break;
        }
    }
    public static Pizza addSignaturePizza(Scanner scanner){
        System.out.println(YELLOW + "\n=====SIGNATURE PIZZA'S=====" + RESET);
        System.out.println(BLUE + "1. Margherita Pizza" + RESET);
        System.out.println(BLUE + "2. Veggie Pizza" + RESET);
        int option = Integer.parseInt(scanner.nextLine());
        switch (option){
            case 1:
                return new MargheritaPizza();
            case 2:
                return new VeggiePizza();
            default:
                System.out.println(RED + "Invalid Option" + RESET);
                return null;
        }
    }
}
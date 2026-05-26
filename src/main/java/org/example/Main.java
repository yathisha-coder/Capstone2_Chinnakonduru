package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("======HOME SCREEN=======");
            System.out.println("1. New Order");
            System.out.println("0. Exit");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    orderScreen(scanner);
                break;
                case "0":
                    System.out.println("Thank You for shopping! Please come again!");
                    break;
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
            String option = scanner.nextLine();
        }
    }
}
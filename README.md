# PIZZA WORLD - Point of Sale Application

## Project Overview

PIZZA WORLD is a Java console-based Point of Sale (POS) application designed for a custom pizza restaurant.
This application allows customers to create fully customized pizza orders, add drinks and garlic knots, calculate totals, process payments, and generate receipt files automatically.

The project was built using Object-Oriented Programming (OOP) principles including:

* Inheritance
* Encapsulation
* Polymorphism
* Abstraction
* Enums
* Collections
* File Handling
* Streams

---

# Features

## Home Screen

* Start a new order
* Exit the application

---

## Order Screen

* Add Custom Pizza
* Add Signature Pizza
* Add Drinks
* Add Garlic Knots
* Checkout
* Cancel Order

---

## Pizza Customization

Customers can:

* Select pizza size

  * Personal
  * Medium
  * Large

* Select crust type

  * Thin
  * Regular
  * Thick
  * Cauliflower

* Choose stuffed crust

* Add toppings

  * Meat toppings
  * Cheese toppings
  * Regular toppings
  * Sauces

---

## Signature Pizzas

### Margherita Pizza

* Medium
* Regular crust
* Basil
* Tomatoes
* Olive Oil

### Veggie Pizza

* Personal
* Regular crust
* Bell Peppers
* Spinach
* Olives

---

## Drinks

Customers can:

* Select drink size
* Enter drink flavor

---

## Garlic Knots

* Add multiple garlic knots using quantity

---

## Checkout & Payment

Supports:

* Cash payments
* Debit card payments
* Credit card payments

---

## Receipt System

* Receipts are automatically saved into the `receipts` folder
* Receipt filenames use timestamps

Example:
20260528-104522.txt

---

# Technologies Used

* Java
* IntelliJ IDEA
* Git & GitHub
* ASCII Table Library

---

# Project Structure

src/
├── Main.java
├── MenuItem.java
├── Order.java
├── Pizza.java
├── Drink.java
├── GarlicKnots.java
├── Topping.java
├── ReceiptManager.java
├── PizzaSize.java
├── DrinkSize.java
├── CrustType.java
├── ToppingType.java
├── MargheritaPizza.java
└── VeggiePizza.java

receipts/

---

# Object-Oriented Design

## Inheritance

`Pizza`, `Drink`, and `GarlicKnots` inherit from the abstract `MenuItem` class.

## Polymorphism

All menu items override:

* `calculatePrice()`
* `getReceiptText()`

## Encapsulation

Class properties are private and accessed through methods.

## Abstraction

`MenuItem` provides shared abstract behavior.

---

# Pricing Features

* Pizza base prices vary by size
* Topping prices vary by pizza size
* Extra toppings increase cost
* Stuffed crust adds additional cost
* Drink prices vary by size

---

# Sample Receipt

+----------------------+--------+
| ITEM                 | PRICE  |
+----------------------+--------+
| Custom Pizza         | $18.50 |
| Drink                | $2.50  |
| Garlic Knots         | $1.50  |
+----------------------+--------+
| TOTAL                | $22.50 |
+----------------------+--------+

---

# How to Run

1. Clone the repository
2. Open in IntelliJ IDEA
3. Run `Main.java`
4. Start placing orders

---

# Author

Created by [Yathisha Sai]

Capstone Project - Java Development Program

---

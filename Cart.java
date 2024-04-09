/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.giantgroceryreceipttester;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ellie
 */
// cart class



/*shopping cart, holds list of Product items, provides methods to add items,
 calculates total price, performs checkout*/
public class Cart {
    private final List<Product> items = new ArrayList<>();

    /*adds Product item to the cart
     * method can accept any subclass of Product, PackagedProduct/UnPackagedProduct
     * @param item Product item add to cart*/
    
    public void addItem(Product item) {
        items.add(item);
    }

    /*calculates total price
     *method assumes Product class/subclasses have method to get price of item
     *@return total price of all items in cart*/
    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice(); // assumes getPrice() is method in Product class
        }
        return total;
    }

    /*performs checkout process
     *method calculates total price of items in cart, calls Commands.do_checkout() method
     *prints total price,assumes Commands class has do_checkout() method that accepts flags for checkout options */
    public void checkout() {
        double total = calculateTotal();
        // assuming getPrice() is method in Product class and returns price of item
        // Commands.do_checkout() is method that handles checkout process
        groupproject.Commands.do_checkout(new String[]{"-d"}); // example of passing flags to checkout if needed
        groupproject.InputHandler.print("Total: " + total);
    }
}
<<<<<<<< Updated upstream:ReceiptMain.java

import java.util.ArrayList;

/**
 * Represents a product with a name and price.
 */
class Product {
    private String name;
    private double price;

    /**
     * Constructs a product with the specified name and price
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the product.
     returns the price of the product
     */
    public double getPrice() {
        return price;
    }
}

/**
 * Represents a receipt containing a list of products.
 */
class Receipt {
    private ArrayList<Product> items;

    /**
     * Constructs an empty receipt.
     */
    public Receipt() {
        items = new ArrayList<>();
    }

    /**
     * Adds an item from product to the receipt.
     */
    public void addItem(Product product) {
        items.add(product);
    }

    /**
     * Calculates the total price of all products in the receipt.
     * retunrs the total price of all products
     */
    public double getTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    /**
     *Formats reciept 
     */
    @Override
    public String toString() {
        String receiptString = "Receipt:\n";
        receiptString += "----------------------------------------\n";
        for (int i = 0; i < items.size(); i++) {
            Product item = items.get(i);
            receiptString += (i + 1) + ". " + item.getName() + ": $" + String.format("%.2f", item.getPrice()) + "\n";
        }
        receiptString += "----------------------------------------\n";
        receiptString += "Total: $" + String.format("%.2f", getTotal());
        return receiptString;
    }
}

========

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a receipt containing a list of products.
 */
public class Receipt {
    
    private ArrayList<Product> items;

    /**
     * Constructs an empty receipt.
     */
    public Receipt() {
        items = new ArrayList<>();
    }
    
    /**
     * Constructs a Receipt with passed items ArrayList.
     * @param itemList 
     */
    public Receipt(ArrayList<Product> itemList) {
        items = (ArrayList<Product>)itemList.clone();
    }

    /**
     * Adds an item from product to the receipt.
     */
    public void addItem(Product product) {
        items.add(product);
    }

    /**
     * Calculates the total price of all products in the receipt.
     * returns the total price of all products
     */
    public double getTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice();
        }
        return total;
    }

    /**
     *Formats receipt 
     */
    @Override
    public String toString() {
        String receiptString = "Receipt:\n";
        receiptString += "----------------------------------------\n";
        for (int i = 0; i < items.size(); i++) {
            Product item = items.get(i);
            receiptString += (i + 1) + ". " + item.getName() + ": $" + String.format("%.2f", item.getPrice()) + "\n";
        }
        receiptString += "----------------------------------------\n";
        receiptString += "Total: $" + String.format("%.2f", getTotal());
        return receiptString;
    }



    public void toFile(String path){
        try (FileWriter outFile = new FileWriter(path)) {      
            outFile.write(this.toString());
        } catch (IOException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}

>>>>>>>> Stashed changes:src/Receipt.java

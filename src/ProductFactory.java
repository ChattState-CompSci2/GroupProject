// Weston Hale
// A00267225

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * The `ProductFactory` class is responsible for loading and managing the `Product` objects that represent items in a shopping cart.
* It stores these objects in a map with the `Product`'s SKU as the key.
*/
public class ProductFactory {
    private Map<String, Product> products = new TreeMap<>();

    /**
     * Called when an item is added to the cart. The function creates a new `Product` object and adds it to the map.
*/
    public void addProduct(Product product) {
        products.put(product.getSku(), product);
    }

    /**
     * Called when an item is removed from the cart. The function removes the item from the map.
*/
    public void removeProduct(String sku) {
        products.remove(sku);
    }

    /**
     * Called when a total price is calculated. The function calculates the total price of all items in the cart.
*/
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            product = entry.getValue();
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    /**
     * Called when a specific product is requested. The function looks up the product in the map and returns it.
*/
    public Product getProduct(String sku) {
        return products.get(sku);
    }

    /**
     * Called when there is an error loading or processing products. The function prints the error message.
*/
    public void handleError() {
        System.out.println("Error loading or processing products");
    }
}
``


import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * ProductFactory class loads and manages the 'Product' objects that represent shopping cart items.
*  It saves these objects in a map using the Product's SKU as the key.
*/
public class ProductFactory {
    private Map<String, Product> products = new TreeMap<>();

    /**
     * Called whenever an item is added to the cart. The function defines a new 'Product' object and adds it to the map.
*/
    public void addProduct(Product product) {
        products.put(product.getSku(), product);
    }

    /**
     * Called when an item is removed from the cart. The function removes the item from the map.
*/
    public void removeProduct(String sku) {
        products.remove(sku);
    }

    /**
     * When the full price is calculated. The function totals the prices of all products in the cart.
*/
    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            product = entry.getValue();
            totalPrice += product.getPrice() * product.getQuantity();
        }
        return totalPrice;
    }

    /**
     * When a specific product is requested, the call is placed. The function looks up and returns the product from the map.
*/
    public Product getProduct(String sku) {
        return products.get(sku);
    }

    /**
     * Called when there is a problem loading or processing products. The function prints an error message.
*/
    public void handleError() {
        System.out.println("Error loading or processing products");
    }
}


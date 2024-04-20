package groupproject;


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
}


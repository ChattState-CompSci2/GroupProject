
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Represents a receipt containing a list of products.
 */
public class Receipt {
    
    private ArrayList<CartItem> items;
    private java.util.Date dateCreated;

    /**
     * Constructs an empty receipt.
     */
    public Receipt() {
        items = new ArrayList<>();
        this.dateCreated = new java.util.Date();
    }
    
    /**
     * Constructs a Receipt with passed items ArrayList.
     * @param itemList 
     */
    public Receipt(ArrayList<CartItem> itemList) {
        items = (ArrayList<CartItem>)itemList.clone();
        this.dateCreated = new java.util.Date();
    }

    /**
     * Calculates the total price of all products in the receipt.
     * returns the total price of all products
     */
    public double getTotal(){
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice() + item.getTax();
        }
        return total;
    }

    /**
     *Formats receipt 
     */
    @Override
    public String toString() {
        String receiptString = String.format("Receipt: %s\n", this.getDateString());
        receiptString += "----------------------------------------\n";
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            receiptString += String.format("[%d] %-10s Price: $%.2f Tax: $%.2f\n", i, item.getProduct().getName(), item.getPrice(), item.getTax());
        }
        receiptString += "----------------------------------------\n";
        receiptString += "Total: $" + String.format("%.2f", getTotal());
        return receiptString;
    }



    public void toFile(String path){
        try (FileWriter outFile = new FileWriter(path + this.getDateString() + ".txt")) {      
            outFile.write(this.toString());
        } catch (IOException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public String getDateString(){
        return this.dateCreated.toString().replace(":", "-");
    }
}


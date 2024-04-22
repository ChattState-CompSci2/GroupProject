import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A receipt containing a list of items with their quantity, price, and tax.
 */
public class Receipt {
    
    private ArrayList<CartItem> items;
    private java.util.Date dateCreated;

    /**
     * Constructs an empty receipt and initializes the creation date.
     */
    public Receipt() {
        items = new ArrayList<>();
        this.dateCreated = new java.util.Date();
    }
    
    /**
     * Constructs a receipt with a pre-existing list of items and initializes the creation date.
     * @param itemList ArrayList of CartItem objects to be included in the receipt.
     */
    public Receipt(ArrayList<CartItem> itemList) {
        items = (ArrayList<CartItem>) itemList.clone();
        this.dateCreated = new java.util.Date();
    }

    /**
     * @return The total cost of the items in the cart.
     */
    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice() + item.getTax();
        }
        return total;
    }

    /**
     * @return A formatted string of the receipt.
     */
    @Override
    public String toString() {
        StringBuilder receiptString = new StringBuilder();
        receiptString.append(String.format("\nReceipt: %s\n", this.getDateString()));
        receiptString.append("----------------------------------------\n");
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            receiptString.append(String.format("[%d] %-10s Price: $%.2f Tax: $%.2f\n", i, item.getProduct().getName(), item.getPrice(), item.getTax()));
        }
        receiptString.append("----------------------------------------\n");
        receiptString.append("Total: $" + String.format("%.2f\n", getTotal()));
        return receiptString.toString();
    }

    /**
     * Saves the receipt to a file.
     * @param path Directory path for the receipt.
     */
    public void toFile(String path) {
        try (FileWriter outFile = new FileWriter(path + this.getDateString() + ".txt")) {      
            outFile.write(this.toString());
        } catch (IOException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    /**
     * @return A date string with colons replaced by dashes.
     */
    public String getDateString() {
        return this.dateCreated.toString().replace(":", "-");
    }
}
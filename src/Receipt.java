
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
    public String getReceipt(double cash) {
        String receiptString = String.format("Receipt: %s\n", this.getDateString());
        receiptString += "----------------------------------------\n";
        for (int i = 0; i < items.size(); i++) {
            CartItem item = items.get(i);
            receiptString += String.format("[%d] %-10s Price: $%.2f Tax: $%.2f\n", i, item.getProduct().getName(), item.getPrice(), item.getTax());
        }
        receiptString += "----------------------------------------\n";
        receiptString += "Total: $" + String.format("%.2f\n", getTotal());

        receiptString += String.format("Tender: $%.2f\n", cash);
        receiptString += String.format("Change: %s\n", getChangeString(getTotal(), cash));
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

    public String getChangeString (double owed, double payment) {
        double change = payment - owed;
        System.out.println("Subtotal: $" + owed + "\nAmount Payed: $" + payment + "\nChange: $" + change + "\n");
        
        String result = "";

        if (change >= 50.00) {
            int fifties = findCoin (change, 50.00);
            change -= 50.00 * fifties;
            result += ("\nFifties: " + fifties);

        }
        if (change >= 20.00) {
            int twenties = findCoin (change, 20.00);
            change -= 20.00 * twenties;
            result += ("\nTwenties: " + twenties);

        }
        if (change >= 10.00) {
            int tens = findCoin (change, 10.00);
            change -= 10.00 * tens;
            result += ("\nTens: " + tens);

        }
        if (change >= 5.00) {
            int fives = findCoin (change, 5.00);
            change -= 5.00 * fives;
            result += ("\nFives: " + fives);

        }
        if (change >= 1.00) {
            int ones = findCoin (change, 1.00);
            change -= 1.00 * ones;
            result += ("\nOnes: " + ones);
            
        }
        if (change >= 0.25) {
            int quarters = findCoin (change, 0.25);
            change -= 0.25 * quarters;
            result += ("\nQuarters: " + quarters);
            
        }
        if (change >= 0.10) {
            int dimes = findCoin (change, 0.10);
            change -= 0.10 * dimes;
            result += ("\nDimes: " + dimes);

        }
        if (change >= 0.05) {
            int nickels = findCoin (change, 0.05);
            change -= 0.05 * nickels;
            result += ("\nNickels: " + nickels);

        }
        if (change > 0.00) {
            int pennies = findCoin (change, 0.01);
            change -= 0.01 * pennies;
            result += ("\nPennies: " + pennies);

        }
        return result;
    }
    
    public int findCoin (double change, double value) {
        int finalCoin = 0;
        double coin = change;
        if (coin >= value) {
            while (coin >= value) {
                coin -= value;
                finalCoin ++;
            }
            return finalCoin;
        }
        else {
            return 0;
        }
    }
}



import java.util.Map;
import java.util.Scanner;


public class Register_OS {
    public static ProductFactory pfac;
    public static CommandHandler ch;
    public static Boolean exitProgram = false;
    static Scanner in = null;

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
 
        // Initializes the Scanner and Command Handler
        in = new Scanner(System.in);
        ch = new CommandHandler();

        // Initialize Product list
        pfac = new ProductFactory();
        if (!pfac.loadProducts("products.json", "products")) {
            System.exit(0);
        }

        // Add commands. Command Name, Method and Help Text
        ch.addCommand("START", new Command(() -> doTransaction(), "Starts a new order"));
        ch.addCommand("SEARCH", new Command(() -> searchProduct(), "Search the product list"));
        ch.addCommand("LIST", new Command(() -> listProducts(), "List all available products"));
        ch.addCommand("EXIT", new Command(() -> exitProgram = true, "Exits the program"));
        ch.addCommand("QUIT", new Command(() -> exitProgram = true, "Exits the program"));


        // List commands to the user
        ch.listCommands();

        // Main input loop for handling commands
        try{
            while(exitProgram == false){

                System.out.print("Enter Command: ");
                if(in.hasNextLine()){
                    Command c = ch.getCommand(in.nextLine());
                    if(c != null){
                        // Run the bound method stored in the Command
                        c.run();
                    }
                    else{
                        System.out.println("Invalid Command!");
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Caught Exception: " + e.getMessage());
        }

        in.close();
    }


    /**
     * Function called via Command
     * Creates an instance of Cart and begins a transaction.
     * Handles adding to the card, checkout, saving the recipt and printing change
     */
    public static void doTransaction() {
        Cart cart = new Cart();
    
        try {
            System.out.println("Enter 'C' to Checkout");
    
            // Loop until user decides to checkout
            while (true) {
                System.out.print("Enter Product SKU or Name: ");
                if (!in.hasNextLine()) {
                    continue;
                }
                String text = in.nextLine().trim();
    
                // If user enters 'C', break the loop and proceed to checkout
                if (text.equalsIgnoreCase("C")) {
                    break;
                }
    
                // Remove the most recent item if user input starts with '-'
                if (text.startsWith("-") && cart.getItems().size() > 0) {
                    CartItem removedItem = cart.removeLast();
                    if (removedItem != null) {
                        System.out.println("\tRemoved " + removedItem.getProduct());
                    }
                    continue;
                }
    
                // Add Product
                Product product = pfac.getProduct(text);
                if (product != null) {
                    // Check if product is Weighable
                    if (product instanceof WeighableProduct) {
                        System.out.print("Enter Product Weight: ");
                        if (in.hasNextDouble()) {
                            double weight = in.nextDouble();
                            if (weight > 0.0) {
                                cart.add((WeighableProduct) product, weight);
                                System.out.printf("\tAdded %s to cart\n", product);
                                in.nextLine(); // Skip the newline
                                continue;
                            }
                        }
                        // Displayer Error
                        System.out.println("Invalid weight input.");
                        in.nextLine(); // Skip the newline
                    } 
                    else {
                        // Default to 1 quantity on non weighable
                        cart.add(product, 1);
                        System.out.printf("\tAdded %s to cart\n", product);
                    }
                } 
                else {
                    // Display error message
                    System.out.println("No product found!");
                }
            }
    
            // After adding all items, prompt for cash amount and proceed to checkout
            System.out.printf("Amount Due: $%.2f\nEnter Cash Amount: ", cart.getTotal());
            if (in.hasNextDouble()) {
                double cashAmount = in.nextDouble();
                if (cashAmount > cart.getTotal()) {
                    cart.checkout(cashAmount);
                    in.nextLine(); // Skip the newline
                    return;
                }
            }
    
            // If invalid cash amount, display error message
            System.out.println("Invalid cash amount. Transaction aborted!");
            in.nextLine(); // Skip the newline
        } 
        catch (Exception e) {
            // If any exception occurs, display error message
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
    
    /**
     * Function called via Command
     * The user inputs a SKU or Name to search the entire product list.
     */
    public static void searchProduct(){
        try {
            System.out.print("Enter Product SKU or Name: ");
            String text = in.nextLine().trim();
            Product p = pfac.getProduct(text);
            if(p != null){
                System.out.println(p);
            }
            else{
                System.out.println("No product found!");
            }
        }
        catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }


    /**
     * Function called via Command
     * Prints the entire list of loaded products. 
     */
    public static void listProducts(){
        Map<Integer, Product> products = pfac.getProducts();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

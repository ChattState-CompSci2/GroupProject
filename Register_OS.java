
import java.util.Map;
import java.util.Scanner;


public class Register_OS {
    public static ProductFactory pfac;
    public static CommandHandler ch;
    public static Boolean exitProgram = false;
    static Scanner in = null;

    public static void main(String[] args) {
 
        // Allocate the transaction list and Command Handler
        in = new Scanner(System.in);
        ch = new CommandHandler();

        // Initialize Product list
        pfac = new ProductFactory();
        if (!pfac.loadProducts("products.json", "products")) {
            System.exit(0);
        }

        // Add commands
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


    // 
    public static void doTransaction() {
        Cart cart = new Cart();
        
        try {
            System.out.println("Enter 'C' to Checkout");
            
            while (true) {
                System.out.print("Enter Product SKU or Name: ");
                if (!in.hasNextLine()) {
                    continue;
                }
                String text = in.nextLine().trim();
    
                if (text.equalsIgnoreCase("C")) {
                    break;
                }
    
                Product p = pfac.getProduct(text);
    
                if (p != null) {
                    if (p instanceof WeighableProduct) {
                        System.out.print("Enter Product Weight: ");
                        if (in.hasNextDouble()) {
                            double weight = in.nextDouble();
                            cart.add((WeighableProduct) p, weight);
                        } 
                        else {
                            System.out.println("Invalid weight input.");
                        }
                        in.nextLine(); // Skip the newline
                    } 
                    else {
                        cart.add(p, 1);
                    }
                } 
                else {
                    System.out.println("No product found!");
                }
            }
    
            // Save to the transaction history list
            System.out.printf("Amount Due: $%.2f\nEnter Cash Amount: ", cart.getTotal());
            if (in.hasNextDouble()) {
                double cashAmount = in.nextDouble();
                cart.checkout(cashAmount);
            } 
            else {
                System.out.println("Invalid cash amount input.");
            }

            in.nextLine(); // Skip the newline
        } 
        catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    
    // Search Command
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


    // List All Products Command
    public static void listProducts(){
        Map<Integer, Product> products = pfac.getProducts();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

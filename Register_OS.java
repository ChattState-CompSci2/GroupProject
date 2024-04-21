
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Register_OS {
    public static ProductFactory pfac;
    public static CommandHandler ch;

    public static List<Cart> transactions;

    public static Boolean exitProgram = false;


    public static void main(String[] args) {
 
        // Allocate the transaction list and Command Handler
        transactions = new ArrayList<>();
        ch = new CommandHandler();

        // Initialize Product list
        pfac = new ProductFactory();
        if (!pfac.loadProducts()) {
            System.exit(0);
        }


        // Add commands
        ch.addCommand("START", new Command(() -> doTransaction(), "Starts a new order"));
        ch.addCommand("SEARCH", new Command(() -> searchProduct(), "Search the product list"));
        ch.addCommand("LIST", new Command(() -> listProducts(), "List all available products"));
       // ch.addCommand("HISTORY", new Command(() -> getHistory(), "Find a previous transaction"));
        ch.addCommand("HELP", new Command(() -> ch.listCommands(), "List all commands and their help text"));
        ch.addCommand("EXIT", new Command(() -> exitProgram = true, "Exits the program"));
        ch.addCommand("QUIT", new Command(() -> exitProgram = true, "Exits the program"));


        // Main input loop for handling commands
        try(Scanner in = new Scanner(System.in)){
            while(exitProgram == false && in.hasNext()){
                Command c = ch.getCommand(in.next());
                if(c != null){
                    // Run the bound method stored in the Command
                    c.run();
                }
                else{
                    System.out.println("Invalid Command!");
                }
            }
        }
        catch(Exception e){
            System.out.println("Caught Exception: " + e.getMessage());
        }

    }

    public static void doTransaction(){
        Cart cart = new Cart();
        
        try(Scanner in = new Scanner(System.in)){

            System.out.println("Enter 'C' to Checkout");

            while(true){

                System.out.print("Enter Product SKU or Name: ");
                if(!in.hasNext()){
                    continue;
                }
                String text = in.nextLine();
                Product p = pfac.getProduct(text);

                if(text.equalsIgnoreCase("C")){
                    break;
                }
                // Check if it is a weightable Product
                else if(p != null && p instanceof WeighableProduct){
                    System.out.print("Enter Product Weight: ");
                    if(in.hasNextDouble()){
                        double weight = in.nextDouble();
                        cart.add((WeighableProduct) p, weight);
                    }
                }
                else if( p != null){
                    cart.add(p, 1);
                }
                else{
                    System.out.println("No product found!");
                }
            }

            // Save to the transaction history list
            System.out.printf("Ammount Due: %f\n Enter Cash Ammount: ", cart.getTotal());
            if(in.hasNextDouble()){
                double cashAmmount = in.nextDouble();
                cart.checkout(cashAmmount);
            }
        }
        catch(Exception e){
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void searchProduct(){

    }

    public static void listProducts(){
        Map<Integer, Product> products = pfac.getProducts();
        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}

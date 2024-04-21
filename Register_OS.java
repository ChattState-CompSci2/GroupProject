
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * Merged class that combines the functionality of Register_OS and Cart.
 * It allows users to select products, add them to a cart, and perform checkout.
 * @author Ellie
 */

public class Register_OS {
    public static ProductFactory pfac;
    public List<Receipt> transactions;
    public static Map<String, Command> methods;
    public static Boolean exitProgram = false;

    public static void main(String[] args) {

        
        // Initialize Product list
        pfac = new ProductFactory();
        if (!pfac.Init()) {
            System.exit(0);
        }


        Commands.Initialize();
        methods = new HashMap<>();
        methods.put("START", new Command(() -> startTransaction(), "Starts a new order"));
        methods.put("SEARCH", new Command(() -> startTransaction(), "Search the product list"));
        methods.put("LIST", new Command(() -> startTransaction(), "List all available products"));
        methods.put("HISTORY", new Command(() -> startTransaction(), "Find a previous transaction"));
        methods.put("EXIT", new Command(() -> exitProgram = true, "Exits the program"));
        methods.put("QUIT", new Command(() -> exitProgram = true, "Exits the program"));



        try(Scanner in = new Scanner(System.in)){
            while(exitProgram == false && in.hasNext()){
                Command c = methods.get(in.next().toUpperCase());
                if(c != null){
                    c.run(); // Run the bound method stored in the Command
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

    public static void startTransaction(){

    }

    public static void searchProduct(){

    }

    public static void getHistory(){

    }

    public static void quitProgram(){

    }

    public static void run() {
        System.out.println("Loaded " + pfac.GetProductList().size() + " products");
        Scanner in = new Scanner(System.in);

        while (true) {

            Cart cart = new Cart(); // Initialize the shopping cart

            System.out.print("Enter Product SKU or Name: ");
            Product p = null;

            if (in.hasNext()) {
                String name = in.nextLine();
                p = pfac.GetProduct(name);
            }

            if (p != null) {
                if (p instanceof WeighableProduct) {
                    WeighableProduct wp = (WeighableProduct) p;
                    System.out.print("Enter Product Weight: ");
                    double weight = in.nextDouble();
                    System.out.printf("%d %s Price:$%.2f TaxRate:%.2f%% Total: $%.2f\n",
                            wp.getSku(), wp.getName(), wp.getPrice(weight), wp.getTax() * 100.0f, wp.getPrice(weight) + (wp.getPrice(weight) * wp.getTax()));
                    cart.addItem(wp); // Add the product to the cart
                } else {
                    System.out.printf("%d %s Price:$%.2f TaxRate:%.2f%% Total: $%.2f\n",
                            p.getSku(), p.getName(), p.getPrice(), p.getTax() * 100.0f, p.getPrice() + (p.getPrice() * p.getTax()));
                    cart.addItem(p); // Add the product to the cart
                }
            }

            System.out.print("Do you want to checkout? (yes/no): ");
            String checkout = in.nextLine();
            if (checkout.equalsIgnoreCase("yes")) {
                cart.checkout(); // Perform checkout
                break; // Exit the loop after checkout
            }
        }
    }

}

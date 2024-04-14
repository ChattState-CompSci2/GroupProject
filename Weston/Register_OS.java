package groupproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Merged class that combines the functionality of Register_OS and Cart.
 * It allows users to select products, add them to a cart, and perform checkout.
 * @author Ellie
 */
public class Register_OS {
    private ProductFactory pfac;
    private Cart cart; // Instance of Cart class to manage shopping cart operations

    public Register_OS() {
        pfac = new ProductFactory();
        if (!pfac.Init()) {
            System.exit(0);
        }
        cart = new Cart(); // Initialize the shopping cart
    }

    public static void main(String[] args) {
        Register_OS app = new Register_OS();
        app.run();
    }

    public void run() {
        System.out.println("Loaded " + pfac.GetProductList().size() + " products");
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Product SKU or Name: ");
            Product p = null;

            if (in.hasNextInt()) {
                Integer sku = in.nextInt();
                p = pfac.GetProduct(sku);
            } else if (in.hasNext()) {
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

        // Inner class for Cart
    private class Cart {
        private final List<Product> items;

        public Cart() {
            items = new ArrayList<>();
        }

        public void addItem(Product product) {
            items.add(product);
        }

        public void checkout() {
            double totalPrice = 0.0;
            for (Product item : items) {
                totalPrice += item.getPrice();
            }
            System.out.println("Items in the cart:");
            for (Product item : items) {
                System.out.println(item.getName() + " - $" + item.getPrice());
            }
            System.out.println("Total Price: $" + totalPrice);
            items.clear();
        }
    }
}
}

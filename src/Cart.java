import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The Cart class contains a list of CartItem used at checkout
 */
public class Cart {
    private List<CartItem> items;

    /**
     * Constructs an empty shopping cart.
     */
    public Cart() {
        items = new ArrayList<>();
    }

    /**
     * Adds a product with a specific quantity to the cart.
     * @param product
     * @param quantity
     */
    public void add(Product product, double quantity) {
        items.add(new CartItem(product, quantity));
    }

    /**
     * Removes and returns the last item added to the cart.
     * @return The last CartItem added to the cart.
     */
    public CartItem removeLast(){
        return items.remove(items.size() - 1);
    }

    /**
     * @return The total cost of the items in the cart.
     */
    public double getTotal(){
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice() + item.getTax();
        }
        return total;
    }

    /**
     * @return The list of CartItems
     */
    public List<CartItem> getItems(){
        return items;
    } 

    /**
     * Prints the receipt, and saves it to a file and returns the change values.
     * @param cash The amount of cash provided by the customer.
     */
    public void checkout(double cash) {
        Receipt r = new Receipt((ArrayList<CartItem>)items);
        System.out.println(r.toString());
        r.toFile("transactions/");

        System.out.printf("Tender: $%.2f\n%s\n\n", cash, Change.getChangeString(getTotal(), cash));
    }

}
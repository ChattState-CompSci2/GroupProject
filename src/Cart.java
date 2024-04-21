import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void add(Product product, double quantity) {
        items.add(new CartItem(product, quantity));
    }

    public CartItem removeLast(){
        return items.removeLast();
    }

    public double getTotal(){
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice() + item.getTax();
        }
        return total;
    }


    public void checkout(double cash) {
        
        Receipt r = new Receipt((ArrayList<CartItem>)items);
        System.out.println("Here is your receipt!\n" + r.getReceipt(cash));
        r.toFile("transactions/");
    }

}

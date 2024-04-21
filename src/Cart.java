import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private java.util.Date dateCreated;

    public Cart() {
        items = new ArrayList<>();
        this.dateCreated = new java.util.Date();
    }

    public void add(Product product, double quantity) {
        items.add(new CartItem(product, quantity));
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
        System.out.println("Here is your receipt!\n" + r.toString());
        r.toFile("transactions/" + this.getDateString() + ".txt");
    }

    public String getDateString(){
        return this.dateCreated.toString().replace(":", "-");
    }

}

import java.util.ArrayList;
import java.util.List;

public class Cart {
        private final List<Product> items;
        private java.util.Date dateCreated;

        public Cart() {
            items = new ArrayList<>();
            this.dateCreated = new java.util.Date();
        }

        public void addItem(Product product) {
            items.add(product);
        }

        public void checkout() {
            double totalPrice = 0.0;
            for (Product item : items) {
                totalPrice += item.getPrice();
            }
            
            Receipt r = new Receipt((ArrayList<Product>)items);
            System.out.println("Here is your receipt!\n" + r.toString());
            
            items.clear();
        }

        public java.util.Date getDateCreated(){
            return this.dateCreated;
        }
}

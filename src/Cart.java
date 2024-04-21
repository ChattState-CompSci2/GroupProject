/**
 * The Cart class represents a shopping cart containing a list of items.
* The items in the cart can be added, removed, calculated the total price, and checked out.
*/

class Cart {
    private List<CartItem> items;

    /**
     * Creates a new Cart with an empty items list.
*/
    public Cart() {
        items = new ArrayList<>();
    }

    /**
     * Adds a new CartItem to the cart with the given product and quantity.
* @param product The product to be added
* @param quantity The quantity of the product to be added
*/
    public void add(Product product, double quantity) {
        items.add(new CartItem(product, quantity));
    }

    /**
     * Removes and returns the last CartItem from the cart.
* @return The last CartItem removed from the cart.
*/
    public CartItem removeLast() {
        return items.removeLast();
    }

    /**
     * Returns the total price of all items in the cart.
* @return The total price of all items in the cart.
*/
    public double getTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice() + item.getTax();
        }
        return total;
    }

    /**
     * Checkouts the cart and generates a receipt.
* @param cash The amount of cash used for checkout
*/
    public void checkout(double cash) {
        Receipt r = new Receipt((ArrayList<CartItem>)items);
        System.out.println("Here is your receipt!\n" + r.getReceipt(cash));
        r.toFile("transactions/");
    }
}


/**
 * The CartItem class represents an item in a shopping cart.
*/

class CartItem {

    /**
     * The product that this item represents.
*/
    private Product product;

    /**
     * The quantity of this item in the cart.
*/
    private double quantity;

    /**
     * The price of this item.
*/
    private double price;

    /**
     * The tax of this item.
*/
    private double tax;

    /**
     * Creates a new CartItem with the given product and quantity.
* If the product is WeighableProduct, then the price and tax are calculated based on the product's weight.
* @param product The product to represent
* @param quantity The quantity of the product
*/
    public CartItem(Product product, double quantity) {
        if (product instanceof WeighableProduct) {
            WeighableProduct wp = (WeighableProduct)product;
            price = wp.getPrice(quantity);
            tax = wp.getTax(quantity);
        } else {
            price = product.getPrice();
            tax = product.getTax();
        }
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.tax = tax;
    }

    /**
     * Gets the product that this item represents.
* @return The product that this item represents.
*/
    public Product getProduct() {
        return this.product;
    }

    /**
     * Gets the quantity of this item in the cart.
* @return The quantity of this item in the cart.
*/
    public double getQuantity() {
        return this.quantity;
    }

    /**
     * Gets the price of this item.
* @return The price of this item.
*/
    public double getPrice() {
        return this.price;
    }

    /**
     * Gets the tax of this item.
* @return The tax of this item.
*/
    public double getTax() {
        return this.tax;
    }

}

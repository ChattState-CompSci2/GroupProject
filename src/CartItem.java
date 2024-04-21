/**
 * A item in a shopping cart, which includes a product, quantity, price, and tax.
 */
public class CartItem {

    private Product product;
    private double quantity;
    private double price;
    private double tax;

    /**
     * Constructs a new CartItem with the specified product and quantity.
     * Calculates the price and tax based on the type of product.
     *
     * @param product the product for this cart item
     * @param quantity the quantity or weight of the product
     */
    public CartItem(Product product, double quantity){
        this.product = product;
        this.quantity = quantity;

        if(product instanceof WeighableProduct){
            WeighableProduct wp = (WeighableProduct)product;
            price = wp.getPrice(quantity);
            tax = wp.getTax(quantity);
        }
        else{
            price = product.getPrice();
            tax = product.getTax();
        }
    }

    /**
     * @return the Product class
     */
    public Product getProduct(){
        return this.product;
    }

    /**
     * @return the quantity of the product or Weight for weighable products.
     */
    public double getQuantity(){
        return this.quantity;
    }

    /**
     * @return the price
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * @return the tax
     */
    public double getTax(){
        return this.tax;
    }

}
public class CartItem {

    private Product product;
    private double quantity;
    private double price;
    private double tax;

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

    public Product getProduct(){
        return this.product;
    }

    public double getQuantity(){
        return this.quantity;
    }

    public double getPrice(){
        return this.price;
    }

    public double getTax(){
        return this.tax;
    }

}

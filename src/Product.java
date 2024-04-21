/**
 * A product with SKU, name, price, and tax rate.
 */
class Product implements Comparable<Product> {
    private int sku;
    private String name;
    protected double price;
    protected double tax_rate;

    /**
     * Default constructor.
     */
    public Product() {}

    /**
     * Constructs a new product using the specified parameters
     * @param sku
     * @param name 
     * @param price
     * @param tax_rate tax rate in decimal format Ex: 0.05
     */
    public Product(int sku, String name, double price, double tax_rate) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.tax_rate = tax_rate;
    }

    /**
     * Returns the name of the product.
     * @return the product name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the product.
     * @param name the new name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the product price
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Sets the price of the product.
     * @param price the new price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the tax rate from 0.0 - 1.0
     */
    public double getTaxRate() {
        return this.tax_rate;
    }

    /**
     * Sets the tax rate of the product.
     * @param tax_rate the new tax rate
     */
    public void setTaxRate(double tax_rate) {
        this.tax_rate = tax_rate;
    }

    /**
     * @return the product tax
     */
    public double getTax() {
        return this.price * this.tax_rate;
    }

    /**
     * @return the SKU
     */
    public int getSku() {
        return this.sku;
    }

    /**
     * Sets the SKU of the product.
     * @param sku the new SKU
     */
    public void setSku(int sku) {
        this.sku = sku;
    }

    @Override
    public String toString() {
        return "SKU: " + this.sku + ", Name: " + this.name + ", Price: " + this.price;
    }

    @Override
    public int compareTo(Product otherProduct) {
        return Integer.compare(this.sku, otherProduct.getSku());
    }
}
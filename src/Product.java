
class Product implements Comparable<Product>{
    private int sku;
    private String name;
    protected double price;
    protected double tax_rate;
    
    public Product() {}
    
    public Product(int sku, String name, double price, double tax_rate) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.tax_rate = tax_rate;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTaxRate(){
        return this.tax_rate;
    }

    public double getTax(){
        return this.price * this.tax_rate;
    }

    public void setTaxRate(double tax_rate){
        this.tax_rate = tax_rate;
    }

    public int getSku(){
        return this.sku;
    }

    public void setSku(int sku){
        this.sku = sku;
    }

    @Override
    public String toString() { 
        return "SKU: " + this.sku + ", Name: " + this.name + ", Price: " + this.price ;
    } 

    @Override
    public int compareTo(Product otherProduct) {
        return Integer.compare(this.sku, otherProduct.getSku());
    }
}
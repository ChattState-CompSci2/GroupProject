package groupproject;

class Product {
    private String name;
    protected double price;
    private int sku;
    private double tax_rate;
    
    public Product() {}
    
    public Product(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setTax(double tax_rate){
        this.tax_rate = tax_rate;
    }

    public double getTax(){
        return tax_rate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSku(int sku){
        this.sku = sku;
    }

    public int getSku(){
        return this.sku;
    }
}
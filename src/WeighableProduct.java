

class WeighableProduct extends Product {

    // No default constructor for this class
    
    public double getPrice(double weight) {
        return this.price * weight;
    }

    public double getTax(double weight){
        return (this.price * this.tax_rate) * weight;
    }
}
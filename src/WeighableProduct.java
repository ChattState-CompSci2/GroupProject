/**
 * The WeighableProduct class enhances the Product class by providing functionality for calculating a product's price and tax based on its weight.
* The total price is calculated by multiplying the product's price by its weight.
*/

class WeighableProduct extends Product {
    public double getPrice(double weight) {
        return this.price * weight;
    }
    
/**
* To compute total tax, multiply the product's tax rate by the total price multiplied by the weight.
* The total price is the sum of the price plus the tax.
*/
    public double getTax(double weight){
        return (this.price * this.tax_rate) * weight;
    }
}

/**
 * A product that can be weighed, extending the Product class.
 */
class WeighableProduct extends Product {

    // No default constructor for this class

    /**
     * Calculates the price of the product using the weight.
     * @param weight the weight of the product
     * @return the price of the product * weight
     */
    public double getPrice(double weight) {
        return this.price * weight;
    }

    /**
     * Calculates the tax of the product using the weight.
     * @param weight the weight of the product
     * @return the taxof the product * weight
     */
    public double getTax(double weight){
        return (this.price * this.taxRate) * weight;
    }
}
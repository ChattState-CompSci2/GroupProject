package groupproject;

public class UnPackagedProduct extends Product{
    private double weightOrQuantity; //need an exception message if user inputs something like 1.1 for a quantity item that can't be divided, or slip into two classes that are weighed or quantity
    /**
     * Empty Constructor
     */
    public UnPackagedProduct() {
 
    }
    /**
    * Default Constructor
    * @param weightOrQuantity
    * @param name
    */
    public UnPackagedProduct(double weightOrQuantity, String name) {
        super(name);
        this.weightOrQuantity = weightOrQuantity;
    }
    /**
     * returns information of an UnPackagedProduct object
     * @return
     */
    @Override
    public String toString() {
        return "UnPackagedProduct{" + "weightOrQuantity=" + weightOrQuantity + '}';
    }
}

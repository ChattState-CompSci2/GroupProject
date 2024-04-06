public class Product {
    private String name;
    /**
     * Empty Constructor
     */
    public Product() {
    }
    /**
     * Default Constructor
     * @param name
     */
    public Product(String name) {
        this.name = name;
    }
    /**
     * returns information of a product object
     * @return
     */
    @Override
    public String toString() {
        return "Product{" + "name=" + name + '}';
    }
}

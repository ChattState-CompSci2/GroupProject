public class Product {
    private String name;
    
    public Product() {
    }
    
    public Product(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + '}';
    }
}

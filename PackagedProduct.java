package groupproject;

public class PackagedProduct extends Product{
    private int barcode;
    /**
     * Default Constructor
     * @param name
     * @param barcode
     */
    public PackagedProduct(String name, int barcode) {
        super(name);
        this.barcode = barcode;
    }
    /**
     * returns information of a PackagedProduct object
     * @return
     */
    @Override
    public String toString() {
        return "PackagedProduct{" + "barcode=" + barcode + '}';
    }
}


import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * A factory class for allocating and searching products.
 */
public class ProductFactory {

    private Map<Integer, Product> products;

    /**
     * Constructs a new ProductFactory and initializes the product map.
     */
    public ProductFactory(){
        products = new TreeMap<>();
    }

    /**
     * Loads products from a JSON file into the factorys product map.
     * @param fileName The name of the JSON file.
     * @param jsonArray The name of the JSON array containing product data.
     * @return true if products are loaded successfully, false if not.
     */
    public Boolean loadProducts(String fileName, String jsonArray){
        JsonReader j_Read = new JsonReader();
        try {
            JsonArray productJArray = j_Read.readJsonArrayFromFile(fileName, jsonArray);
                
            if(!productJArray.isEmpty()){
                
                for (JsonElement pElement : productJArray) {
                    
                    JsonObject pObj = pElement.getAsJsonObject();

                    Boolean weighable = pObj.get("WEIGHABLE").getAsBoolean();       
                    Product p = weighable ? new WeighableProduct() : new Product();
                    
                    p.setName(pObj.get("PRODUCT_NAME").getAsString());
                    p.setPrice(pObj.get("PRICE_RETAIL").getAsDouble());
                    p.setTaxRate(pObj.get("TAX_RATE").getAsDouble());
                    p.setSku(pObj.get("SKU").getAsInt());
                    
                    products.put(p.getSku(), p);
                }
            }
            return true;
        } 
        catch (Exception e) {
            System.out.println("Exception on JSON reader!");
        }
        return false;
    }

    /**
     * @return The product map.
     */
    public Map<Integer, Product> getProducts(){
        return products;
    }

    /**
     * Gets a product by its name or ID.
     * @param nameOrID The name or ID of the product.
     * @return The product if found, null if not.
     */
    public Product getProduct(String nameOrID){
        try {
            Integer pID = Integer.parseInt(nameOrID);
            return getProductByID(pID);
        } 
        catch (NumberFormatException e) {
            return getProductByName(nameOrID);
        }
    }

    /**
     * Gets a product by its name.
     * @param name The name of the product.
     * @return The product if found, null if not.
     */
    private Product getProductByName(String name){

        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            Product p = entry.getValue();
            if(name.equalsIgnoreCase(p.getName())){
                return p;
            }
        }
        return null;
    }

    /**
     * Gets a product by its ID.
     * @param ID The ID of the product.
     * @return The product if found, null if not.
     */
    private Product getProductByID(Integer ID){
        return products.get(ID);
    }
}
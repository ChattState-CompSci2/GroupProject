// Weston Hale
// A00267225

<<<<<<<< Updated upstream:Weston/src/ProductFactory.java
========

>>>>>>>> Stashed changes:src/ProductFactory.java
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class ProductFactory {

    private Map<Integer, Product> products = null;

    public ProductFactory(){
        products = new TreeMap<>();
    }

    public Boolean Init(){
        JsonReader j_Read = new JsonReader();
        try {
			JsonArray product_json_array = j_Read.read_jarray_from_file("products.json", "products");
			
			if(!product_json_array.isEmpty()){
				for (JsonElement p_element : product_json_array) {
					JsonObject p_obj = p_element.getAsJsonObject();

                    Boolean weightable = p_obj.get("WEIGHABLE").getAsBoolean();       
                    Product p = null;

                    if(weightable){
                        p = new WeighableProduct();
                    }
                    else{
                        p = new Product();
                    }
<<<<<<<< Updated upstream:Weston/src/ProductFactory.java

					p.setName(p_obj.get("PRODUCT_NAME").getAsString());
					p.setPrice(p_obj.get("PRICE_RETAIL").getAsDouble());
========
                    
                    p.setName(p_obj.get("PRODUCT_NAME").getAsString());
                    p.setPrice(p_obj.get("PRICE_RETAIL").getAsDouble());
>>>>>>>> Stashed changes:src/ProductFactory.java
                    p.setTax(p_obj.get("TAX_RATE").getAsDouble());
					p.setSku(p_obj.get("SKU").getAsInt());

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


    public Map<Integer, Product> GetProductList(){
        return products;
    }

    // Takes in a string and determines if you entered a SKU or product name
    public Product GetProduct(String nameOrID){
        try {
            Integer pID = Integer.parseInt(nameOrID);
            return GetProductByID(pID);
        } catch (NumberFormatException e) {
            return GetProductByName(nameOrID);
        }
    }

    // Search by string
    private Product GetProductByName(String name){

        for (Map.Entry<Integer, Product> entry : products.entrySet()) {
            Product p = entry.getValue();
            if(name.toLowerCase().equals(p.getName().toLowerCase())){
                return p;
            }
        }
        return null;
    }

    // Search by ID
    private Product GetProductByID(Integer ID){
        return products.get(ID);
    }
}

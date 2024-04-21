// Weston Hale
// A00267225


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// Googles JSON reader for Java
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

public class JsonReader {
    
    public JsonArray read_jarray_from_file(String file_name, String array_name){

        try{
            Reader reader = new FileReader(file_name);
            Gson gson = new Gson();

			JsonElement j_element = gson.fromJson(reader, JsonElement.class);
			JsonArray j_pro_array = j_element.getAsJsonObject().getAsJsonArray(array_name);

            return j_pro_array.deepCopy(); // This seems to be necesary else the object is destroyed after the function ends on return.
        }
        catch(IOException e){
            System.out.println("Caught IOException: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Caught Exception: " + e.getMessage());
        }
        
        // Return empty array on fail
        return new JsonArray();
    }
}

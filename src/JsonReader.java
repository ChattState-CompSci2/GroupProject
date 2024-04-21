
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

// Googles JSON reader for Java
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;

/**
 * A class for reading a JSON array from a file using the Google Gson library for Java.
 */
public class JsonReader {
    
    /**
     * Reads a JSON array from a file.
     * @param fileName The name of the file to read the JSON array from.
     * @param arrayName The name of the JSON array to read.
     * @return A JsonArray object of the JSON array read.
     * @throws IOException If an IO error occurs while reading the file.
     */
    public JsonArray readJsonArrayFromFile(String file_name, String array_name){

        try{
            Reader reader = new FileReader(file_name);
            Gson gson = new Gson();

			JsonElement j_element = gson.fromJson(reader, JsonElement.class);
			JsonArray j_pro_array = j_element.getAsJsonObject().getAsJsonArray(array_name);
            // Deep Copy seems to be necessary else the object is destroyed after the function ends on return.
            return j_pro_array.deepCopy();
        }
        catch(IOException e)
        {
            System.out.println("Caught IOException: " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Caught Exception: " + e.getMessage());
        }
        
        // Return empty array on fail
        return new JsonArray();
    }
}

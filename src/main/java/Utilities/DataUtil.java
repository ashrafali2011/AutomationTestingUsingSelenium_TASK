package Utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class DataUtil {
    public static final String TEST_DATA_PATH = "src/test/resources/TestData/";

    public static String getJsonData(String jsonFileName, String jsonField) {
        try {
            FileReader fileReader = new FileReader(TEST_DATA_PATH + jsonFileName + ".json");
            JsonElement jsonElement = JsonParser.parseReader(fileReader);
            return jsonElement.getAsJsonObject().get(jsonField).getAsString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "" ;
    }

    public static String getPropertyValue(String filename,String key) throws IOException {
        Properties properties=new Properties();
        properties.load(new FileInputStream((TEST_DATA_PATH+filename+".properties")));
        return properties.getProperty(key);
    }

}

package org.ClearTrip.com.utility;
import java.io.FileInputStream;
import java.util.Properties;

public class    ConfigReader {
    private static Properties prop = new Properties();
    static{
        try{
            FileInputStream file = new FileInputStream("config.properties");
            prop.load(file);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getProperties(String key){
        String value = prop.getProperty(key);
        return value;
    }
}

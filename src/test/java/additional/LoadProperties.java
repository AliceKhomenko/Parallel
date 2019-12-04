package additional;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    public static  Properties init(){
        Properties properties = new Properties();

        FileInputStream input = null;
        try {
            input = new FileInputStream("src/test/resources/configuration.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    return properties;

    }
}

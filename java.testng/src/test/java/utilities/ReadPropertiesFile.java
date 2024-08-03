package utilities;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static base.Constants.PROPERTY_FILE_PATH;
/**
 * The Class has all TestProperties (All properties mentioned in <strong>config.properties</strong> file).
 *
 * @author Kamalesh N
 */

public class ReadPropertiesFile {


    public static FileReader fileReader;
    /** The Constant props. */
    public static Properties properties;
    /**
     * Load all properties from config.properties file.
     */
    public String FileReader(String key)  {
        try {
            fileReader = new FileReader(PROPERTY_FILE_PATH);
        } catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
        properties = new Properties();
        try {
            properties.load(fileReader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }

}

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ReadPropertiesFile;
import java.time.Duration;

/**
 * The Class is responsible in maintaining Browser Start and Stop.
 *
 * @author Kamalesh N
 */
public class BrowserStartStop extends ReadPropertiesFile {

    /** The driver instance.
     * Gets the driver from properties file
     * Gets the TestURL from properties file
     * Browser Start
     */
    public static WebDriver driver;
    ReadPropertiesFile propertiesFile = new ReadPropertiesFile();

    /** The driver instance.
     * * Setup.
     * */
    public void browserStart() {
        if (driver == null) {
            try {
                if (propertiesFile.FileReader("browser").equalsIgnoreCase("chrome")) {
                    driver = new ChromeDriver();
                } else if (propertiesFile.FileReader("browser").equalsIgnoreCase("firefox")) {
                    driver = new FirefoxDriver();
                }
                driver.get(propertiesFile.FileReader("testUrl"));
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            } catch (NullPointerException e) {
                System.out.print("NullPointerException Caught in Setup");
            }

        } else {
            if (propertiesFile.FileReader("browser").equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (propertiesFile.FileReader("browser").equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();
            }
            driver.get(propertiesFile.FileReader("testUrl"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        }
    }

    /**
     * Wrap up.
     */
    public  void browserStop(){
        driver.close();
    }
}
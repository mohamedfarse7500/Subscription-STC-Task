package Setup;

import com.beust.jcommander.Parameter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;

public class DriverSetup {
    public static WebDriver driver;

    @Before
    public void startUp (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        }

        @After
        public void tearDown () {
            if (driver != null) {
                driver.quit();
            }
        }
    }

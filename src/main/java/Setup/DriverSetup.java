package Setup;

import com.beust.jcommander.Parameter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import static Utils.configuration.getBrowser;

public class DriverSetup {
    public static WebDriver driver;

    @Before
    public void startUp() {
        switch (getBrowser()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                    driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

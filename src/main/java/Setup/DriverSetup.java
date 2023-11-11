package Setup;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

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
    public void teardown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {

            takeScreenShot(scenario.getName(), driver);
        }


        if (driver != null) {
            driver.quit();
        }
    }

    public void takeScreenShot(String testmethodname, WebDriver driver) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String time = java.time.LocalTime.now().toString().replace(":", "-").substring(0, 5);
        String date = java.time.LocalDate.now().toString();
        String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + date + "_" + time + "\\"
                + testmethodname + "_" + ThreadLocalRandom.current().nextInt() + ".png";
        try {
            FileUtils.copyFile(source, new File(destination));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

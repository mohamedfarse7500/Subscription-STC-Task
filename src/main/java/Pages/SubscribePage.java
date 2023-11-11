package Pages;

import Utils.JsonFileHandler;
import io.qameta.allure.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SubscribePage {

    WebDriver driver;

    public SubscribePage(WebDriver driver) {
        this.driver = driver;
    }

    List<WebElement> pricelbl() {
        return driver.findElements(By.xpath("//div[@class='plan-names']/descendant::div[@class='price']"));
    }

    WebElement currencylbl() {
        return driver.findElement(By.xpath("//div[@class='plan-names']/descendant::div[@class='price']"));
    }
    List<WebElement> planslbl() {
        return driver.findElements(By.xpath("//div[@class='plan-names']/descendant::strong[@class='plan-title']"));
    }


    WebElement countryBAH() {
        return driver.findElement(By.id("bh"));
    }

    WebElement countryKUW() {
        return driver.findElement(By.id("kw"));
    }

    WebElement countriesList() {
        return driver.findElement(By.id("country-btn"));
    }

    WebElement litePackageTitle() {
        return driver.findElement(By.id("name-lite"));
    }

    WebElement litePackageCurrency() {
        return driver.findElement(By.id("currency-lite"));
    }

    WebElement classicPackageTitle() {
        return driver.findElement(By.id("name-classic"));
    }

    WebElement classicPackageCurrency() {
        return driver.findElement(By.id("currency-classic"));
    }

    WebElement premiumPackageTitle() {
        return driver.findElement(By.id("name-premium"));
    }

    WebElement premiumPackageCurrency() {
        return driver.findElement(By.id("currency-premium"));
    }

    WebElement countryKSA() {
        return driver.findElement(By.id("sa"));
    }

    public void clickOnCountriesList() {
        countriesList().click();

    }

    public void clickOnKSA() {
        countryKSA().click();
    }

    public void clickOnBAH() {
        countryBAH().click();
    }

    public void clickOnKUW() {
        countryKUW().click();
    }


    public String getLitePackageTitle() {
        return litePackageTitle().getText();
    }


    public String[] getExpectedPrices(String countrykey) {
        JsonFileHandler jsonfilehandler = new JsonFileHandler();
        JSONObject countriesData = jsonfilehandler.loadJson("CountriesData");

        JSONArray typeData = countriesData.getJSONObject(countrykey).getJSONArray("type");
        String[] prices = new String[typeData.length()];
        for (int i = 0; i < typeData.length(); i++) {
            JSONObject typeObject = typeData.getJSONObject(i);
            prices[i] = typeObject.getString(typeObject.keys().next());
        }
        return prices;
    }

    public String[] getActualPrices()
    {
        List<WebElement> labels = pricelbl();
        String[] labelTexts = new String[labels.size()];
        int i = 0;
        for (WebElement label : labels) {
            labelTexts[i++] = label.getText();
        }
        for( i = 0 ; i < labelTexts.length ; i++)
        {
            labelTexts[i] = labelTexts[i].split(" ")[0];
        }
        return labelTexts;
    }

    public String getActualCurrency()
    {
        return currencylbl().getText().split(" ")[1].split("/")[0];
    }

    public String getExpectedCurrency(String countrykey)
    {
        JsonFileHandler jsonfilehandler = new JsonFileHandler();
        JSONObject countriesData = jsonfilehandler.loadJson("CountriesData").getJSONObject(countrykey);

        return countriesData.getString("Currency");
    }

    public String[] getActualType()
    {
        List<WebElement> labels = planslbl();
        String[] labelTexts = new String[labels.size()];
        int i = 0;
        for (WebElement label : labels) {
            labelTexts[i++] = label.getText();
        }
        return labelTexts;
    }

    public String[] getExpectedType(String countrykey) {
        JsonFileHandler jsonfilehandler = new JsonFileHandler();
        JSONObject countriesData = jsonfilehandler.loadJson("CountriesData");

        JSONArray typeData = countriesData.getJSONObject(countrykey).getJSONArray("type");
        String[] plans = new String[typeData.length()];
        for (int i = 0; i < typeData.length(); i++) {
            JSONObject typeObject = typeData.getJSONObject(i);
            plans[i] = typeObject.keys().next();
        }
        return plans;
    }

}

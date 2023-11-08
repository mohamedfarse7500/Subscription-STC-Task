package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Setup.DriverSetup.driver;

public class SubscribePage {

    WebDriver driver;

    public SubscribePage(WebDriver driver) {
        this.driver = driver;
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

    public String getLitePackageCurrency() {
        return litePackageCurrency().getText();
    }

    public String getClassicPackageTitle() {
        return classicPackageTitle().getText();
    }

    public String getClassicPackageCurrency() {
        return classicPackageCurrency().getText();
    }

    public String getPremiumPackageTitle() {
        return premiumPackageTitle().getText();
    }

    public String getPremiumPackageCurrency() {
        return premiumPackageCurrency().getText();
    }

    public String genrateFullPrice(String currency, String price) {
        return price + " " + currency + "/month";
    }


}

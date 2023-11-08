package StepsDefinitions;

import Pages.SubscribePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.sql.SQLOutput;

import static Setup.DriverSetup.driver;
import static Utils.configuration.getURL;

public class TestCountries {
    SubscribePage subscribePage;

    @Given("User opens STC website")
    public void userOpensSTCEWebsite() {
        driver.get(getURL());
        subscribePage = new SubscribePage(driver);
    }

    @When("User can open countries list")
    public void userCanChooseCountryFromCountryList() {
        subscribePage.clickOnCountriesList();
    }

    @And("User choose {string} from countries list")
    public void userChooseKSAFromCountryList(String countryName) {
        switch (countryName) {
            case "KSA":
                subscribePage.clickOnKSA();
                break;
            case "BAH":
                subscribePage.clickOnBAH();
                break;
            case "KUW":
                subscribePage.clickOnKUW();

        }
    }
    @Then("Validate plans {string},{string} and {string}  and Currency {string} for all countries")
    public void validatePlansAndCurrencyForAllCountries(String litePrice, String classicPrice, String premiumPrice,String currency)
    {
        Assert.assertEquals(subscribePage.getLitePackageCurrency(),subscribePage.genrateFullPrice(currency,litePrice));
        Assert.assertEquals(subscribePage.getClassicPackageCurrency(),subscribePage.genrateFullPrice(currency,classicPrice));
        Assert.assertEquals(subscribePage.getPremiumPackageCurrency(),subscribePage.genrateFullPrice(currency,premiumPrice));
    }
}

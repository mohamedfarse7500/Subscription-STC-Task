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
    public void userChooseCountryFromCountryList(String countryName) {

        switch (countryName) {
            case "KSA":
                subscribePage.clickOnKSA();
                break;
            case "Bahrain":
                subscribePage.clickOnBAH();
                break;
            case "Kuwait":
                subscribePage.clickOnKUW();

        }
    }


    @Then("Validate plans prices for {string}")
    public void validatePlansPricesForCountry(String country) {
        Assert.assertEquals(subscribePage.getActualPrices(), subscribePage.getExpectedPrices(country));
    }
    @Then("Validate plans currency for {string}")
    public void validatePlansCurrencyForCountry(String country) {
        Assert.assertEquals(subscribePage.getActualCurrency(), subscribePage.getExpectedCurrency(country));


    }
    @Then("Validate plans type for {string}")
    public void validatePlansTypeForCountry(String country) {
        Assert.assertEquals(subscribePage.getActualType(), subscribePage.getExpectedType(country));


    }
}

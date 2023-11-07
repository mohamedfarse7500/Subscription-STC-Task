package StepsDefinitions;

import Pages.SubscribePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.sql.SQLOutput;

import static Setup.DriverSetup.driver;

public class TestCountries {
    SubscribePage subscribePage;

    @Given("User opens STC website")
    public void userOpensSTCEWebsite() {
        driver.get("https://subscribe.stctv.com/sa-en");
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

    @Then("Validate type , price and Currency for {string}")
    public void validateTypePriceAndCurrencyForKSA(String countryName) {
        switch (countryName) {
            case "KSA":
                Assert.assertEquals(subscribePage.getLitePackageTitle(), "LITE");
                Assert.assertTrue(subscribePage.getLitePackageCurrency().contains("15 SAR"));

                Assert.assertEquals(subscribePage.getClassicPackageTitle(), "CLASSIC");
                Assert.assertTrue(subscribePage.getClassicPackageCurrency().contains("25 SAR"));

                Assert.assertEquals(subscribePage.getPremiumPackageTitle(), "PREMIUM");
                Assert.assertTrue(subscribePage.getPremiumPackageCurrency().contains("60 SAR"));

                break;
            case "BAH":
                Assert.assertEquals(subscribePage.getLitePackageTitle(), "LITE");
                Assert.assertTrue(subscribePage.getLitePackageCurrency().contains("2 BHD"));

                Assert.assertEquals(subscribePage.getClassicPackageTitle(), "CLASSIC");
                Assert.assertTrue(subscribePage.getClassicPackageCurrency().contains("3 BHD"));

                Assert.assertEquals(subscribePage.getPremiumPackageTitle(), "PREMIUM");
                Assert.assertTrue(subscribePage.getPremiumPackageCurrency().contains("6 BHD"));
                break;
            case "KUW":
                Assert.assertEquals(subscribePage.getLitePackageTitle(), "LITE");
                Assert.assertTrue(subscribePage.getLitePackageCurrency().contains("1.2 KWD"));

                Assert.assertEquals(subscribePage.getClassicPackageTitle(), "CLASSIC");
                Assert.assertTrue(subscribePage.getClassicPackageCurrency().contains("2.5 KWD"));

                Assert.assertEquals(subscribePage.getPremiumPackageTitle(), "PREMIUM");
                Assert.assertTrue(subscribePage.getPremiumPackageCurrency().contains("4.8 KWD"));

        }

    }
}

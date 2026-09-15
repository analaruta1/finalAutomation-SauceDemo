package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HeaderPage;
import utils.DriverManager;

public class CommonSteps {
    HeaderPage headerPage = new HeaderPage(DriverManager.getDriver().driver);

    @Given("I am in sauce demo web page")
    public void goToSauceDemoPage(){
        DriverManager.getDriver().driver.get(DriverManager.BASE_URL);
    }

    @When("I navigate directly to {string}")
    public void navigateDirectlyTo(String path){
        DriverManager.getDriver().driver.get(DriverManager.BASE_URL + path);
    }

    @Then("The page title should be {string}")
    public void verifyPageTitle(String expectedTitle){
        Assertions.assertEquals(expectedTitle, headerPage.getPageTitle());
    }
}

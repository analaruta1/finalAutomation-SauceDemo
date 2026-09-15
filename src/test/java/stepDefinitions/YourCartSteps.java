package stepDefinitions;

import io.cucumber.java.en.When;
import pages.YourCartPage;
import utils.DriverManager;

public class YourCartSteps {
    YourCartPage yourCartPage = new YourCartPage(DriverManager.getDriver().driver);

    @When("I click on the checkout button")
    public void clickOnCheckoutButton(){
        yourCartPage.clickOnCheckoutButton();
    }
}

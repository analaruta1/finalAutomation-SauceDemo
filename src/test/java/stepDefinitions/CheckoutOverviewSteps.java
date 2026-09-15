package stepDefinitions;

import io.cucumber.java.en.When;
import pages.CheckoutOverviewPage;
import utils.DriverManager;

public class CheckoutOverviewSteps {
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver().driver);

    @When("I click on finish button")
    public void clickOnFinishButton(){
        checkoutOverviewPage.clickOnFinishButton();
    }
}

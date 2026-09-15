package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.CheckoutCompletePage;
import utils.DriverManager;

public class CheckoutCompleteSteps {
    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(DriverManager.getDriver().driver);

    @Then("A message that says {string} should be displayed")
    public void verifyCheckoutCompleteMessage(String expectedMessage){
        Assertions.assertEquals(expectedMessage, checkoutCompletePage.getCheckoutCompleteMessage());
    }
}

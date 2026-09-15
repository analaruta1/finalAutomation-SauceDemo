package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import pages.CheckoutYourInformationPage;
import utils.DriverManager;

import java.util.List;

public class CheckoutYourInformationSteps {
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(DriverManager.getDriver().driver);

    @And("I fill the checkout information with")
    public void fillCheckoutInformationForm(DataTable checkoutYourInformation){
        // |Jorge|Perez|12345|  ->  ['Jorge', 'Perez', '12345']
        // Se usan las celdas "crudas" para que una celda vacía llegue como texto vacío
        List<String> data = checkoutYourInformation.cells().get(0);
        checkoutYourInformationPage.setFirstNameTextBox(data.get(0));
        checkoutYourInformationPage.setLastNameTextBox(data.get(1));
        checkoutYourInformationPage.setZipCodeTextBox(data.get(2));
    }

    @And("I click on the continue button")
    public void clickOnContinueButton(){
        checkoutYourInformationPage.clickOnContinueButton();
    }

    @Then("The checkout error message {string} should be displayed")
    public void verifyCheckoutErrorMessage(String expectedMessage){
        Assertions.assertEquals(expectedMessage, checkoutYourInformationPage.getErrorMessage());
    }
}

package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.CheckoutYourInformationPage;
import utils.DriverManager;

import java.util.List;

public class CheckoutYourInformationSteps {
    CheckoutYourInformationPage checkoutYourInformationPage = new CheckoutYourInformationPage(DriverManager.getDriver().driver);

    @And("I fill the checkout information with")
    public void fillCheckoutInformationForm(DataTable checkoutYourInformation) throws InterruptedException {
        // |Jorge|Perez|12345|
        List<String> data = checkoutYourInformation.transpose().asList(String.class);
        // ['Jorge', 'Perez', '12345']
        checkoutYourInformationPage.setFirstNameTextBox(data.get(0));
        checkoutYourInformationPage.setLastNameTextBox(data.get(1));
        checkoutYourInformationPage.setZipCodeTextBox(data.get(2));
    }

    @And("I click on the continue button")
    public void clickOnContinueButton(){
        checkoutYourInformationPage.clickOnContinueButton();
    }
}

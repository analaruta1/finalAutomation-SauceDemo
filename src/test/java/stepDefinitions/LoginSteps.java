package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps {
    LoginPage loginPage = new LoginPage(DriverManager.getDriver().driver);

    @Given("I set the user name text box with {string}")
    public void setUserName(String userName){
        loginPage.setUserNameTextBox(userName);
    }

    @And("I set the password text box with {string}")
    public void setPassword(String password){
        loginPage.setPasswordTextBox(password);
    }

    @When("I click on the login button")
    public void clickOnLoginButton(){
        loginPage.clickOnLoginButton();
    }

    @Then("A error message that says {string} should be displayed")
    public void verifyErrorMessageIsDisplayed(String message){
        Assertions.assertTrue(loginPage.isErrorMessageDisplayed());
        Assertions.assertEquals(message, loginPage.getErrorMessage());
    }

    @Then("The login page should be displayed")
    public void verifyLoginPageIsDisplayed(){
        Assertions.assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @And("No protected content should be visible")
    public void verifyNoProtectedContent(){
        Assertions.assertFalse(loginPage.isProtectedContentDisplayed(),
                "Protected content is visible without an active session");
    }
}

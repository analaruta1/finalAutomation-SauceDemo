package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HomePage;
import utils.DriverManager;

import java.util.List;

public class HomeSteps {

    HomePage homePage = new HomePage(DriverManager.getDriver().driver);

    @Then("The home pages should be displayed")
    public void verifyHomePageIsDisplayed(){
        boolean isHomePageDisplayed = homePage.homeTitleIsDisplayed();
        Assertions.assertTrue(isHomePageDisplayed);
    }

    @Then("The product {string} should be displayed")
    public void verifyProductIsDisplayed(String productName){
        List<String> actualProducts = homePage.getProductNames();
        Assertions.assertTrue(actualProducts.contains(productName));
    }

    @And("I add the product {string} to the cart")
    public void addProductToCart(String product){
        homePage.addProductToCart(product);
    }

    @When("I add the following products to the cart")
    public void addProductsToCart(DataTable products){
        for(String product: products.asList()){
            homePage.addProductToCart(product);
        }
    }

    @And("I verify that the cart icon displays {string}")
    public void verifyCartIconAmount(String amount){
        Assertions.assertEquals(amount, homePage.getShoppingCartIconText());
    }

    @When("I remove the product {string} from the cart")
    public void removeProductFromCart(String product){
        homePage.removeProductToCart(product);
    }

    @And("I click on the cart icon")
    public void clickOnCartIcon(){
        homePage.clickOnCartIcon();
    }
}

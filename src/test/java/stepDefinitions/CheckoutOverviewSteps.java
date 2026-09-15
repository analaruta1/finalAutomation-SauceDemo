package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.CheckoutOverviewPage;
import utils.DriverManager;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CheckoutOverviewSteps {
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(DriverManager.getDriver().driver);

    @When("I click on finish button")
    public void clickOnFinishButton(){
        checkoutOverviewPage.clickOnFinishButton();
    }

    @When("I click on the cancel button")
    public void clickOnCancelButton(){
        checkoutOverviewPage.clickOnCancelButton();
    }

    @Then("The checkout overview should list the following products")
    public void verifyProductsInOverview(DataTable expectedProducts){
        // | Sauce Labs Backpack | 29.99 |
        Map<String, BigDecimal> expected = new LinkedHashMap<>();
        for(List<String> row: expectedProducts.cells()){
            expected.put(row.get(0), new BigDecimal(row.get(1)));
        }
        Assertions.assertEquals(expected, checkoutOverviewPage.getProductsWithPrices());
    }

    @And("The item total should be the sum of the product prices")
    public void verifyItemTotal(){
        BigDecimal sum = BigDecimal.ZERO;
        for(BigDecimal price: checkoutOverviewPage.getProductsWithPrices().values()){
            sum = sum.add(price);
        }
        assertSameAmount(sum, checkoutOverviewPage.getItemTotal());
    }

    @And("The tax should be {int}% of the item total")
    public void verifyTax(int taxRate){
        BigDecimal expectedTax = checkoutOverviewPage.getItemTotal()
                .multiply(BigDecimal.valueOf(taxRate))
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        assertSameAmount(expectedTax, checkoutOverviewPage.getTax());
    }

    @And("The total should be the item total plus tax")
    public void verifyTotal(){
        BigDecimal expectedTotal = checkoutOverviewPage.getItemTotal().add(checkoutOverviewPage.getTax());
        assertSameAmount(expectedTotal, checkoutOverviewPage.getTotal());
    }

    // compareTo ignora la escala (60.4 == 60.40)
    private void assertSameAmount(BigDecimal expected, BigDecimal actual){
        Assertions.assertEquals(0, expected.compareTo(actual),
                "Expected " + expected + " but was " + actual);
    }
}

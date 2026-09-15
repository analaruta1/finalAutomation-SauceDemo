package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import pages.HeaderPage;
import utils.DriverManager;

import java.util.List;

public class SideMenuSteps {
    HeaderPage headerPage = new HeaderPage(DriverManager.getDriver().driver);

    @When("I open the side menu")
    public void openSideMenu(){
        headerPage.openSideMenu();
    }

    @Then("The side menu should display the following options")
    public void verifySideMenuOptions(DataTable expectedOptions){
        List<String> expected = expectedOptions.asList();
        Assertions.assertEquals(expected, headerPage.getSideMenuOptions());
    }

    @And("I select the {string} option from the side menu")
    public void selectSideMenuOption(String option){
        headerPage.selectSideMenuOption(option);
    }
}

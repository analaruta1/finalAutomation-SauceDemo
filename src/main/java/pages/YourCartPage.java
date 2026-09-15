package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class YourCartPage {
    WebDriver driver;
    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    public YourCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getProductNames(){
        List<String> productNamesText = new ArrayList<>();
        for(WebElement productName: productNames){
            productNamesText.add(productName.getText());
        }
        return productNamesText;
    }

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }

    public void clickOnCheckoutButton(){
        checkoutButton.click();
    }

}

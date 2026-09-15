package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "app_logo")
    WebElement homeTitle;

    @FindBy(className = "shopping_cart_link")
    WebElement shoppingCartIcon;

    @FindBy(className = "product_sort_container")
    WebElement sortComboBox;

    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;

    @FindBy(css = "span.title")
    WebElement pageTitle;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean homeTitleIsDisplayed(){
        return homeTitle.isDisplayed();
    }

    public void addProductToCart(String productName){
        String addToCartButtonId = "add-to-cart-"+productName.replace(" ", "-").toLowerCase();
        driver.findElement(By.id(addToCartButtonId)).click();
    }

    public void removeProductToCart(String productName){
        String removeFromCartButtonId = "remove-"+productName.replace(" ", "-").toLowerCase();
        driver.findElement(By.id(removeFromCartButtonId)).click();
    }

    public String getShoppingCartIconText(){
        return shoppingCartIcon.getText();
    }

    public void selectSortComboBox(String optionToSelect){
        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText(optionToSelect);
    }

    public List<String> getProductNames(){
        List<String> productNamesText = new ArrayList<>();
        for(WebElement productName: productNames){
            productNamesText.add(productName.getText());
        }
        return productNamesText;
    }

    public void clickOnCartIcon(){
        shoppingCartIcon.click();
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }


}

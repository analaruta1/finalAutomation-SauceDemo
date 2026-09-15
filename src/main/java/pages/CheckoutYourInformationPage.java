package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutYourInformationPage {
    WebDriver driver;

    @FindBy(id="first-name")
    WebElement firstNameTextBox;

    @FindBy(id="last-name")
    WebElement lastNameTextBox;

    @FindBy(id="postal-code")
    WebElement zipCodeTextBox;

    @FindBy(id="continue")
    WebElement continueButton;

    @FindBy(css="[data-test='error']")
    WebElement errorMessage;

    public CheckoutYourInformationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstNameTextBox(String firstName){
        typeIfNotEmpty(firstNameTextBox, firstName);
    }

    public void setLastNameTextBox(String lastName){
        typeIfNotEmpty(lastNameTextBox, lastName);
    }

    public void setZipCodeTextBox(String zipCode){
        typeIfNotEmpty(zipCodeTextBox, zipCode);
    }

    public void clickOnContinueButton(){
        continueButton.click();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }

    // Las celdas vacías del DataTable llegan como null o "": en ese caso el campo se deja vacío
    private void typeIfNotEmpty(WebElement textBox, String value){
        if(value != null && !value.isBlank()){
            textBox.sendKeys(value);
        }
    }
}

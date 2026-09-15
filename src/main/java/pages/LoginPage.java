package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id="user-name")
    WebElement userNameTextBox;

    @FindBy(id="password")
    WebElement passwordTextBox;

    @FindBy(id="login-button")
    WebElement loginButton;

    @FindBy(tagName = "h3")
    WebElement errorMessage;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUserNameTextBox(String userName){
        userNameTextBox.clear();
        userNameTextBox.sendKeys(userName);
    }

    public void setPasswordTextBox(String password){
        passwordTextBox.clear();
        passwordTextBox.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }

    public boolean isErrorMessageDisplayed(){
        return errorMessage.isDisplayed();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
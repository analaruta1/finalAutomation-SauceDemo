package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

import java.time.Duration;

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

    public boolean isLoginButtonDisplayed(){
        return loginButton.isDisplayed();
    }

    // Revisa si hay contenido protegido (catálogo, detalle, carrito o resumen).
    // Se quita la espera implícita para no esperar 10 s por algo que no debe existir.
    public boolean isProtectedContentDisplayed(){
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        try {
            return !driver.findElements(By.cssSelector(
                    ".inventory_list, .inventory_details, .cart_list, .checkout_summary_container"
            )).isEmpty();
        } finally {
            driver.manage().timeouts().implicitlyWait(DriverManager.IMPLICIT_WAIT);
        }
    }
}

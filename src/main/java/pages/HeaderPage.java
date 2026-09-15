package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// Elementos comunes a todas las páginas internas: título y menú lateral
public class HeaderPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "span.title")
    WebElement pageTitle;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;

    @FindBy(css = ".bm-item-list a")
    List<WebElement> menuOptions;

    public HeaderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return pageTitle.getText();
    }

    public void openSideMenu(){
        menuButton.click();
        // El menú se abre con una animación: esperamos a que las opciones sean visibles
        wait.until(ExpectedConditions.visibilityOfAllElements(menuOptions));
    }

    public List<String> getSideMenuOptions(){
        List<String> optionsText = new ArrayList<>();
        for(WebElement option: menuOptions){
            optionsText.add(option.getText().trim());
        }
        return optionsText;
    }

    public void selectSideMenuOption(String optionText){
        WebElement option = driver.findElement(By.linkText(optionText));
        // Reintenta el clic mientras la animación del menú lo bloquee
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(ElementNotInteractableException.class)
                .until(d -> {
                    option.click();
                    return true;
                });
    }
}

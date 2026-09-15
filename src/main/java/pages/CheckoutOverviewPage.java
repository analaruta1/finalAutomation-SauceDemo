package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CheckoutOverviewPage {
    WebDriver driver;

    @FindBy(id="finish")
    WebElement finishButton;

    @FindBy(id="cancel")
    WebElement cancelButton;

    @FindBy(className="inventory_item_name")
    List<WebElement> productNames;

    @FindBy(className="inventory_item_price")
    List<WebElement> productPrices;

    @FindBy(className="summary_subtotal_label")
    WebElement itemTotalLabel;   // "Item total: $55.97"

    @FindBy(className="summary_tax_label")
    WebElement taxLabel;         // "Tax: $4.48"

    @FindBy(className="summary_total_label")
    WebElement totalLabel;       // "Total: $60.45"

    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnFinishButton(){
        finishButton.click();
    }

    public void clickOnCancelButton(){
        cancelButton.click();
    }

    // Devuelve {nombre del producto -> precio} tal como aparece en el resumen
    public Map<String, BigDecimal> getProductsWithPrices(){
        Map<String, BigDecimal> products = new LinkedHashMap<>();
        for(int i = 0; i < productNames.size(); i++){
            products.put(productNames.get(i).getText(), toAmount(productPrices.get(i).getText()));
        }
        return products;
    }

    public BigDecimal getItemTotal(){
        return toAmount(itemTotalLabel.getText());
    }

    public BigDecimal getTax(){
        return toAmount(taxLabel.getText());
    }

    public BigDecimal getTotal(){
        return toAmount(totalLabel.getText());
    }

    // Convierte textos como "Tax: $4.48" o "$29.99" en 4.48 / 29.99
    private BigDecimal toAmount(String text){
        return new BigDecimal(text.substring(text.indexOf('$') + 1).trim());
    }
}

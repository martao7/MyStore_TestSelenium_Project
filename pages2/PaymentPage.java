package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {
    private static WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // wybierze metodę platnosci

    @FindBy(id = "payment-option-1")
    public WebElement pay;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    public WebElement checkBox;

    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    public WebElement saveButton;

    public void payByCheck() {
        WebElement pay = driver.findElement(By.id("payment-option-1"));
        if (!pay.isSelected())
            pay.click();

        WebElement checkBox = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        if (!checkBox.isSelected())
            checkBox.click();

        WebElement saveButton = driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        saveButton.click();
    }
}
package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickUpPage {
    private static WebDriver driver;

    public PickUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // wybierze metodę odbioru - PrestaShop "pick up in store"

    @FindBy(id = "delivery_option_1")
    public WebElement delivery;

    @FindBy(name = "confirmDeliveryOption")
    public WebElement saveButton;

    public void pickUpInStore() {
        WebElement delivery = driver.findElement(By.id("delivery_option_1"));
        if (!delivery.isSelected())
            delivery.click();

        WebElement saveButton = driver.findElement(By.name("confirmDeliveryOption"));
        saveButton.click();
    }
}
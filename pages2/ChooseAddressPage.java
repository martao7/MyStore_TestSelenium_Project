package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseAddressPage {
    private static WebDriver driver;

    public ChooseAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"id-address-delivery-address-5142\"]/header/label/div")
    public WebElement address;

    @FindBy(name = "confirm-addresses")
    public WebElement saveButton;

    public void addAddress() {
        WebElement address = driver.findElement(By.id("delivery-addresses"));
        if (!address.isSelected())
            address.click();


        WebElement saveButton = driver.findElement(By.name("confirm-addresses"));
        saveButton.click();
    }
}
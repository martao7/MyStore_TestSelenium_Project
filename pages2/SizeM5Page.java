package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SizeM5Page {
    private static WebDriver driver;

    public SizeM5Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "group_1")
    public WebElement size;

    @FindBy(id ="quantity_wanted")
    private WebElement quantity;

    @FindBy(xpath ="//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement addButton;


    public void addProduct() {
        //WebElement size = driver.findElement(By.id("group_1"));
        Select sizeSelect = new Select(size);
        sizeSelect.selectByVisibleText("M");
        size.click();

        //WebElement quantity = driver.findElement(By.id("quantity_wanted"));
        quantity.click();
        quantity.clear();
        quantity.sendKeys("5");

        //WebElement addButton = driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button"));
        addButton.click();
    }
}
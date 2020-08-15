package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseSweaterPage {
    private static WebDriver driver;

    public ChooseSweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // wyszukiwanie produktu na stronie glownej
    @FindBy(xpath = "//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h2/a")
    public WebElement sweaterInput;

    public void sweaterView(String search) {
        WebElement sweaterInput = driver.findElement(By.xpath("//*[@id=\"js-product-list\"]/div[1]/article[1]/div/div[1]/h2/a"));
        sweaterInput.click();
    }
}
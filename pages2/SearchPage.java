package pages2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private static WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    // wyszukiwanie produktu na stronie glownej
    @FindBy(name = "s")
    public WebElement searchInput;

    @FindBy(xpath ="//*[@id=\"search_widget\"]/form/button")
    private WebElement submitButton;

    public void searchOurCatalog(String search) {
        WebElement searchInput = driver.findElement(By.name("s"));
        searchInput.click();
        searchInput.clear();
        searchInput.sendKeys();

        submitButton.click();
    }
}
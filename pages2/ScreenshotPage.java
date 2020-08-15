package pages2;

import org.apache.commons.io.FileUtils;

//import jdk.incubator.jpackage.internal.IOUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotPage {
    private static WebDriver driver;
    //private IOUtils FileUtils;

    public ScreenshotPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //String LocalDateTime now = LocalDateTime.now();
    //DateTimeFormatter

    //screenshot ze strony
    // YOUR ORDER IS CONFIRMED
    // An email has been sent to your mail address yhpzhgytlxpdccugle@awdrt.com.

    @FindBy(id = "content-hook_order_confirmation")
    public WebElement successInfo;


    public static String getUpdateInformation() {
        WebElement successInfo = driver.findElement(By.xpath("//*[@id=\"notifications\"]/div"));
        return successInfo.getText();
    }

    public static void getScreenshotAs() {

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        //String filename = now.format(formatter) + "-screenshot.png";
        String orderScreen = now.format(formatter) + "-screenshot.png";

        try {
            FileUtils.copyFile(scrFile, new File("screenshots/" + orderScreen));
            System.out.println("screenshot of your order is done!");
        } catch (IOException e) {
            System.out.println("Screenshot failed!!!!!fail!!fail!!");
            e.printStackTrace();
        }
    }
}






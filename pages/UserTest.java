package pages;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions (features = "src/Cucumber/Features/", plugin = {"pretty","html:out"})

public class UserTest {
    private static WebDriver driver;

    @Before
    public void setUp() {
        //otwieram strone na ktorej uzytkownik jest zalogowany
        System.setProperty("webdriver.chrome.driver", "src/main/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //czekaj zanim rzucisz wyjatkiem (bo nie mozesz znalezc elementu, bo element zniknal)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @Test
    public void Test() {
        //dodaje kontruktora AddressPage
        LoginPage loginPage = new LoginPage(driver);
        //loginAs do zalogowania
        loginPage.loginAs( "yhpzhgytlxpdccugle@awdrt.com", "pass123");
        Assert.assertEquals("Anna Nowak", loginPage.getLoggedUsername());

        //czekaj zanim rzucisz wyjatkiem (bo nie mozesz znalezc elementu, bo element zniknal)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickToAddresses();
        //Assert.assertEquals(); tutaj dodam sprawdzenie czy przeszlam nadobra strona

        AddressPage addressPage = new AddressPage(driver);

        //czekaj zanim znowu odpalisz
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //sprawdzenie poprawnosci adresu
        //AddressCheckPage addressCheckPage = new AddressCheckPage(driver);
        //Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown () {
        //zakoncz
        //driver.quit();
    }
}

/*
Zadanie warsztatowe 1 - Selenium WebDriver + Cucumber

Utwórz użytkownika manualnie na stronie https://prod-kurs.coderslab.pl/.

Możesz wykorzystać tymczasowego maila do utworzenia
użytkownika https://10minutemail.com/10MinuteMail/index.html.


Napisz skrypt, który:

będzie logować się na tego stworzonego użytkownika,
wejdzie klikając w kafelek Addresses po zalogowaniu
(adres, na którym powinniśmy się znaleźć to:
https://prod-kurs.coderslab.pl/index.php?controller=addresses ),
kliknie w + Create new address,
wypełni formularz New address - dane powinny być
pobierane z tabeli Examples w Gherkinie
(alias, address, city, zip/postal code/country/phone),
sprawdzi czy dane w dodanym adresie są poprawne.
 */

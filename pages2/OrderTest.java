package pages2;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;


@RunWith(Cucumber.class)
@CucumberOptions (features = "src/Cucumber/Features/", plugin = {"pretty","html:out"})

public class OrderTest {
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

        SearchPage searchPage = new SearchPage(driver);
        searchPage.searchOurCatalog("");

        ChooseSweaterPage chooseSweaterPage = new ChooseSweaterPage(driver);
        //jaki wynik po kliknieciu
        //Assert.assertEquals();

        //czekaj zanim odpalisz dalej
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //rozmiar, ilosc, dodaj do koszyka
        SizeM5Page sizeM5Page = new SizeM5Page(driver);

        //czekaj zanim odpalisz dalej
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        CheckOutPage checkOutPage = new CheckOutPage(driver);

        //czekaj zanim odpalisz dalej
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //adres
        ChooseAddressPage chooseAddressPage = new ChooseAddressPage(driver);
        //wysylka
        PickUpPage pickUpPage = new PickUpPage(driver);
        //platnosc
        PaymentPage paymentPage = new PaymentPage(driver);

        //czekaj zanim odpalisz dalej
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //zrob screenshot zamowienia
        ScreenshotPage screenshotPage = new ScreenshotPage(driver);
    }

    @After
    public void tearDown () {
        //zakoncz
        //driver.quit();
    }
}

/*
Zadanie warsztatowe 2 (dowolny sposób)

Napisz skrypt, który:

zaloguje się na tego samego użytkownika z zadania 1,
wybierze do zakupu Hummingbird Printed Sweater ,
wybierze rozmiar M,
wybierze 5 sztuk według parametru podanego w teście,
dodaj produkt do koszyka,
przejdzie do opcji - checkout,
potwierdzi address (możesz go dodać wcześniej ręcznie),
wybierze metodę odbioru - PrestaShop "pick up in store",
wybierze opcję płatności - Pay by Check,
kliknie na "order with an obligation to pay",
zrobi screenshot z potwierdzeniem zamówienia i kwotą.
 */
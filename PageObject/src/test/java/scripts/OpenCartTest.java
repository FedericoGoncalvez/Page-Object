package scripts;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ProductPage;
import pages.ProductSearchPage;

import static org.testng.AssertJUnit.assertEquals;

public class OpenCartTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        // Configurar la instancia del navegador web antes de las pruebas
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }



    @Test
    public void test() throws Exception {
        driver.get("http://opencart.abstracta.us/");
        HomePage homePage = new HomePage(driver);
        ProductSearchPage productSearchPage = homePage.search("MacBook");
        ProductPage productPage = productSearchPage.clickProduct("MacBook");
        assertEquals(productPage.getPrice(), "$602.00");
    }


    @AfterClass
    public static void tearDown() {
        // Cerrar la instancia del navegador web después de todas las pruebas
        driver.quit();
    }

}

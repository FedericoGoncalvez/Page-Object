package scripts;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class WebDriverTest {

    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe" );
        WebDriver driver = new ChromeDriver();

        driver.get("http://opencart.abstracta.us/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));

        WebElement shoppingCart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title=\"Shopping Cart\"]")));
        shoppingCart.click();

        if(wait.until(ExpectedConditions.textToBe(By.cssSelector("#content p"),"Your shopping cart is empty!"))){
            System.out.println("El carrito está lazazo");
        }

    }
}
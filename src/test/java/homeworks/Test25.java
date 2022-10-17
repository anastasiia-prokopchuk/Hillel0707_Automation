package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test25 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void befor(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() {

        WebElement laptopsAndComputerCategory = driver.findElement(By.xpath("//*[@class='menu-categories menu-categories_type_main']/li[1]"));
        laptopsAndComputerCategory.click();

        WebElement laptopCategory = driver.findElement(By.xpath("//*[contains(@href, '80004')]"));
        laptopCategory.click();

        WebElement firstProduct = driver.findElement(By.xpath("//span[@class='goods-tile__title']"));
        String firstProductName = firstProduct.getText();

        WebElement buttonToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'buy-button')]")));
        buttonToCart.click();

        WebElement counterCart = driver.findElement(By.xpath("//span[contains(@class, 'counter')]"));
        String counterCartText = counterCart.getAttribute("innerText").trim();

        Assert.assertEquals(counterCartText,"1","Product doesn't added");

        WebElement buttonCart = driver.findElement(By.xpath("//*[contains(@class,'header__button--active')]"));
        buttonCart.click();

        WebElement productInCart = driver.findElement(By.xpath("//*[@data-testid='title']"));
        String productInCartName = productInCart.getText();

        Assert.assertEquals(firstProductName,productInCartName,"Products doesn't match");

    }

    @AfterTest
    public void after(){
        driver.quit();
    }

}

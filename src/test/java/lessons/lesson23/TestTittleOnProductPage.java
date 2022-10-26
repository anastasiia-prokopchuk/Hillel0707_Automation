package lessons.lesson23;

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

import static org.testng.AssertJUnit.assertEquals;

public class TestTittleOnProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void befor(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() throws InterruptedException {
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("Mac");

        WebElement btnSearch = driver.findElement(By.xpath("//button[contains(@class, 'button_color_green')]"));
        btnSearch.click();

        WebElement firstProduct = wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='goods-tile__title']")));
        String titleOfFirstProduct = firstProduct.getText().trim();
        firstProduct.click();
        WebElement productPageTitle = driver.findElement(By.xpath("//h1[@class='product__title']"));

        String productPageTitleText=productPageTitle.getAttribute("innerText");

        Assert.assertEquals(titleOfFirstProduct,productPageTitleText,"Title dosent equals");

    }

    @AfterTest
    public void after(){
        driver.quit();
    }
}

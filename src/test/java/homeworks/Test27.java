package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.devtools.v85.page.Page.navigate;

public class Test27 {
    private WebDriver driver;

    @BeforeTest
    public void befor(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() throws InterruptedException, IOException {

        List<WebElement> productInBlock = driver.findElements(By.xpath("//*[text()=' Акційні пропозиції ']/following-sibling::ul/li"));
        Assert.assertEquals(productInBlock.size(),6,"Count of products doesn't match");

        WebElement firstProductPrice = driver.findElement(By.xpath("//*[text()=' Акційні пропозиції ']/following-sibling::ul/descendant::span[@class='tile__price-value'][1]"));
        String firstProductPriceText = firstProductPrice.getAttribute("innerText").trim();

        WebElement firstProduct = driver.findElement(By.xpath("//*[text()=' Акційні пропозиції ']/following-sibling::ul/descendant::a[1]"));
        firstProduct.click();

        WebElement priceOnProductPage = driver.findElement(By.xpath("//p[@class='product-prices__big product-prices__big_color_red']"));
        String priceOnProductPageText = priceOnProductPage.getText().trim().replace("₴","");

        Assert.assertEquals(firstProductPriceText, priceOnProductPageText,"Prices doesn't match");

        driver.navigate().back();
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, "https://rozetka.com.ua/ua/","URL doesn't match");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,1000);", "");

        List<WebElement> productInBlockAfterReturn = driver.findElements(By.xpath("//*[text()=' Акційні пропозиції ']/following-sibling::ul/li"));
        Assert.assertEquals(productInBlockAfterReturn.size(),6,"Count of products doesn't match");
    }


    @AfterTest
    public void after(){
        driver.quit();
    }
}

package homeworks.homework24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test24 {
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
    public void rozetkaTest()  {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement laptopsAndComputerCategory = driver.findElement(By.xpath("//rz-sidebar-fat-menu/div/ul/li[1]/a"));
        laptopsAndComputerCategory.click();

        WebElement laptopCategory = driver.findElement(By.xpath("//img[@alt='Ноутбуки']"));
        laptopCategory.click();

        WebElement filterRozetka = wait
                .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='checkbox-filter__item ng-star-inserted']"))));
        filterRozetka.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//main[@class='ng-star-inserted preloader_type_element']")));

        WebElement filterMaxPrice = driver.findElement(By.xpath("//*[@formcontrolname='max']"));
        filterMaxPrice.clear();
        filterMaxPrice.sendKeys("100000");

        WebElement filterButton = driver.findElement(By.cssSelector(".button.button_color_gray"));
        filterButton.click();

        WebElement firstTopProduct = driver.findElement(By.xpath("//span[contains(text(),'ТОП ПРОДАЖІВ')]/following-sibling::a[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);",firstTopProduct);
        firstTopProduct.click();

        WebElement TopProduct = driver.findElement(By.xpath("//*[@class='main-slider__label ng-star-inserted']"));
        Assert.assertTrue(TopProduct.isDisplayed(),"doesn't appeared");

    }

    @AfterTest
    public void after(){
        driver.quit();
    }


}
package lessons.lesson26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_select2 {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void befor(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.autodoc.de");
    }

    @Test
    public void selectTest2() throws InterruptedException {
        WebElement makerList = driver.findElement(By.id("form_maker_id"));
        WebElement makerListOption = driver
                .findElement(By.xpath("//select[@id='form_maker_id']/optgroup[2]/option[@value='2']"));

        makerList.click();
        makerListOption.click();

        TimeUnit.SECONDS.sleep(5);
    }

    @AfterTest
    public void after(){
        driver.quit();
    }

}

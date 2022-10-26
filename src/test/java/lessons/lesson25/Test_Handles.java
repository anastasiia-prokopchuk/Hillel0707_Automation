package lessons.lesson25;

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
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Test_Handles {

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
    public void rozetkaTest() throws InterruptedException {
        WebElement login =driver.findElement((By.xpath("//li[contains(@class, '--user')]")));
        login.click();

        WebElement reg =driver.findElement((By.xpath("//button[contains(@class,'register-link')]")));
        reg.click();

        WebElement privatePolicy =driver.findElement((By.xpath("//a[contains(@class,'button--link')]")));
        privatePolicy.click();

        String mainTab = driver.getWindowHandle();
         for(String tab:driver.getWindowHandles()){
             driver.switchTo().window(tab);
         }


        TimeUnit.SECONDS.sleep(5);
        driver.switchTo().window(mainTab);
        TimeUnit.SECONDS.sleep(5);

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        int lastTab = tabs2.size()-1;
        driver.switchTo().window(tabs2.get(lastTab));


    }

    @AfterTest
    public void after(){
        driver.quit();
    }

}

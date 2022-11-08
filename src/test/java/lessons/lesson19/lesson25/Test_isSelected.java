package lessons.lesson19.lesson25;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test_isSelected {

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
    public void rozetkaTest()  {

        WebElement login =driver.findElement((By.xpath("//li[contains(@class, '--user')]")));
        login.click();

        WebElement rememberCheckboxInput = driver.findElement(By.id("remember_me"));
        WebElement rememberCheckbox = driver.findElement(By.xpath("//label[@for='remember_me']"));


        System.out.println(rememberCheckboxInput.isSelected());

        rememberCheckbox.click();
        System.out.println(rememberCheckboxInput.isSelected());





    }

    @AfterTest
    public void after(){
        driver.quit();
    }


}

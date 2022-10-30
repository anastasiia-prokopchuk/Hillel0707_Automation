package lessons.lesson23;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCheckingLogo_Display_none {
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
    public void rozetkaTest() {
    List<WebElement> logo = driver.findElements(By.xpath("//a[@class='header__logo']"));
    if(logo.size()>0){
        System.out.println("Logo appeared");
    }else{
        Assert.fail("Logo doesn't appeared");
    }

    }

    @AfterTest
    public void after(){
        driver.quit();
    }



}

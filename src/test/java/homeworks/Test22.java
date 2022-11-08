package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test22 {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
    }

    @Test
    public void firstRun() {


        driver.get("https://rozetka.com.ua/ua/");
//        WebElement logoImgCss = driver.findElement(By.cssSelector("img[alt='Rozetka Logo']"));
//        WebElement logoImgXpath = driver.findElement(By.xpath("//img[@alt='Rozetka Logo']"));
//
//        WebElement buttonSearchCss = driver.findElement(By.cssSelector("button.search-form__submit[_ngcontent-rz-client-c98]"));
//        WebElement buttonSearchXpath = driver.findElement(By.xpath("//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']"));
//
//        WebElement buttonPersonCss = driver.findElement(By.cssSelector("button[class='header__button ng-star-inserted']"));
//        WebElement buttonPersonCssXpath = driver.findElement(By.xpath("//button[@class='header__button ng-star-inserted']"));

    }
}

package lessons.lesson27;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class PageObjectTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void befor() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest(){
        new  MainPageLogic(driver,wait)
                .typeTextToSearchInput("Mac")
                .clickFindBtn();

        SearchPageLogic searchPageLogic = new SearchPageLogic(driver,wait);
        String tittleFromSearchPage = searchPageLogic.firstProductTittleText();
        searchPageLogic.clickOnFirstProduct();

        String tittleTextFromProductPage = new ProductPageLogic(driver,wait).getTittleText();

        assertEquals(tittleFromSearchPage, tittleTextFromProductPage);
    }
}

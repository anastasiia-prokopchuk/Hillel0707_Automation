package homeworks.homework26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class SaveProductInTextFile {
//    Перейти на https://rozetka.com.ua/
//    В сайд меню перейти в раздел Ноутбуки и компьютеры
//    Перейти в категорию Ноутбуки
//    На странице поисковой выдачи собрать все тайтлы(название товаров) и цены товаров. (60 штук)
//    Записать их в Map.
//    С помощью FileWriter записать данные с Map в файл rozetkaTest.txt (Пример ОЖ результат: Ноутбук Acer Nitro 5 AN515-57-54K7 (NH.QESEU.003) Shale Black - 32 999)

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
    public void rozetkaTest() throws InterruptedException, IOException {
        new MainPageLogic(driver,wait)
                .laptopsAndComputerCategoryClick()
                .laptopCategoryClick();
        ProductsPageLogic productsPageLogic = new ProductsPageLogic(driver,wait);

        List<WebElement> productsTitle = productsPageLogic.getProductsTitlesList();
        List<WebElement> productsPrice = productsPageLogic.getProductsPricesList();

        CommonLogic commonLogic = new CommonLogic(driver,wait);
        Map<String,String> productsFromFirstPage = commonLogic.writingToMap(productsTitle,productsPrice);
        commonLogic.writingToFile(productsFromFirstPage);
    }

    @AfterTest
    public void after(){
        driver.quit();
    }
}

package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class Test26 {
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
        WebElement laptopsAndComputerCategory = driver.findElement(By.xpath("//*[@class='menu-categories menu-categories_type_main']/li[1]"));
        laptopsAndComputerCategory.click();

        WebElement laptopCategory = driver.findElement(By.xpath("//*[contains(@href, '80004')]"));
        laptopCategory.click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='header__button ng-star-inserted']")));

        List <WebElement> productsTitles = driver.findElements(By.xpath("//span[@class='goods-tile__title']"));
        List<WebElement> productsPrices = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));

        Map<String,String> productsFromFirstPage = writingToMap(productsTitles,productsPrices);
        writingToFile(productsFromFirstPage);
    }

    private static Map<String,String> writingToMap(List<WebElement> productsName, List<WebElement> productsPrice){
        Map<String,String> productsFromFirstPage = new LinkedHashMap<>();
        if(productsName.size()==productsPrice.size()) {
            for (int i = 0; i < productsName.size()-1; i++) {
                String newName = productsName.get(i).getAttribute("innerText").replace(String.valueOf((char) 160),"");
                String newPrice = productsPrice.get(i).getAttribute("innerText").replace(String.valueOf((char) 160),"");

                productsFromFirstPage.put(newName, newPrice);
            }
        }
        return productsFromFirstPage;
    }

    private static void writingToFile (Map<String,String> productsFromFirstPage) throws IOException {
        FileWriter fileWriter = new FileWriter("rozetkaTest.txt");
        for (Map.Entry<String,String> product:productsFromFirstPage.entrySet()){
            fileWriter.write(product.getKey() + " - " + product.getValue()+" грн"+"\n");
        }
        fileWriter.close();
    }

    @AfterTest
    public void after(){
        driver.quit();
    }
}



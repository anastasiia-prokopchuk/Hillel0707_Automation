package homeworks.homework26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class ProductsPageLogic {
    By productTitle = By.xpath("//span[@class='goods-tile__title']");
    By productPrice = By.xpath("//span[@class='goods-tile__price-value']");

    final WebDriver driver;
    final WebDriverWait wait;
    public ProductsPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

}

package homeworks.homework26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


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

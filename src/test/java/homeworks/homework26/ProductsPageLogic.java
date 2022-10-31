package homeworks.homework26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public List<WebElement> getProductsTitlesList() {

        try {
            driver.findElement(productTitle);
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.print("HERE " + productTitle);
            driver.findElement(productTitle);
        }

        List <WebElement> productsTitles = driver.findElements(productTitle);
        return productsTitles;
    }

    public List<WebElement> getProductsPricesList() {
        try {
            driver.findElement(productPrice);
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.print("HERE " + productPrice);
            driver.findElement(productPrice);
        }
        List <WebElement> productsPrices = driver.findElements(productPrice);
        return productsPrices;
    }

}

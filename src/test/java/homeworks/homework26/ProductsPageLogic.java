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

    public List<WebElement> getElementList(By element) {

        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            driver.findElement(element);
        } catch (org.openqa.selenium.StaleElementReferenceException e) {
            System.out.print("HERE " + element);
            driver.findElement(element);
        }

        List <WebElement> elementsList = driver.findElements(element);
        return elementsList;
    }

}

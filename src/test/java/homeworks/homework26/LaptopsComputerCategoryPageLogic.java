package homeworks.homework26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaptopsComputerCategoryPageLogic {
    By laptopCategory = By.xpath("//*[contains(@href, '80004')]");
    final WebDriver driver;
    final WebDriverWait wait;

    public LaptopsComputerCategoryPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public ProductsPageLogic laptopCategoryClick(){
        driver.findElement(laptopCategory).click();
        return new ProductsPageLogic(driver,wait);
    }

}

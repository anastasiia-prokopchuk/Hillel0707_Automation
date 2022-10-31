package homeworks.homework26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {

    By laptopsAndComputerCategory = By.xpath("//*[@class='menu-categories menu-categories_type_main']/li[1]");
    final WebDriver driver;
    final WebDriverWait wait;

    public MainPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LaptopsComputerCategoryPageLogic laptopsAndComputerCategoryClick()  {
        driver.findElement(laptopsAndComputerCategory).click();
        return new LaptopsComputerCategoryPageLogic(driver,wait);
    }
}

package homeworks.homework26;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommonLogic {

    final WebDriver driver;
    final WebDriverWait wait;

    public CommonLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    public Map<String, String> writingToMap(List<WebElement> productsName, List<WebElement> productsPrice) {

        Map<String, String> productsFromFirstPage = new LinkedHashMap<>();
        if (productsName.size() == productsPrice.size()) {
            for (int i = 0; i < productsName.size(); i++) {
                String newName = productsName.get(i).getAttribute("innerText").replace(String.valueOf((char) 160), "");
                String newPrice = productsPrice.get(i).getAttribute("innerText").replace(String.valueOf((char) 160), "");

                productsFromFirstPage.put(newName, newPrice);
            }
        }
        return productsFromFirstPage;
    }

    public void writingToFile(Map<String, String> productsFromFirstPage) throws IOException {
        FileWriter fileWriter = new FileWriter("rozetkaTest2.txt");
        for (Map.Entry<String, String> product : productsFromFirstPage.entrySet()) {
            fileWriter.write(product.getKey() + " - " + product.getValue() + " грн" + "\n");
        }
        fileWriter.close();
    }
}

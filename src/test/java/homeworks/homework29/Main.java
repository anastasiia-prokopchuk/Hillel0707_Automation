package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Main {
    private final MainPageLogic MAIN_PAGE_LOGIC = new MainPageLogic();
    private final ProductsPageLogic PRODUCTS_PAGE_LOGIC = new ProductsPageLogic();


    @BeforeMethod
    public void before(){
        Configuration.browserSize = "2048x1024";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() {
         MAIN_PAGE_LOGIC
                 .clickOnCategory(MAIN_PAGE_LOGIC.laptopsAndComputerCategory)
                 .clickOnCategory(new CategoryPageElement().laptopCategory)
                 .addProductToCart();

         String name = PRODUCTS_PAGE_LOGIC.productName(PRODUCTS_PAGE_LOGIC.firstProduct);
         PRODUCTS_PAGE_LOGIC.checkCountOnCart("1");
         PRODUCTS_PAGE_LOGIC.clickBtnCartHeader()
                 .productInCartName().shouldBe(Condition.text(name));

    }

}

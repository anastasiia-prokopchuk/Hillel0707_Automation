package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class Main {
    private final MainPageLogic MAIN_PAGE_LOGIC = new MainPageLogic();
    private final ProductsPageLogic PRODUCTS_PAGE_LOGIC = new ProductsPageLogic();

    int productIndex = 0;


    @BeforeMethod
    public void before(){
        Configuration.browserSize = "2048x1024";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() {
         MAIN_PAGE_LOGIC
                 .clickOnMainCategory(0)
                 .clickOnCategory(0)
                 .addProductToCart(productIndex);

         String nameOnPage = PRODUCTS_PAGE_LOGIC.getProductName(productIndex);

         PRODUCTS_PAGE_LOGIC.checkCountOnCart("1")
                 .clickBtnCartHeader()
                 .productInCart.shouldBe(Condition.text(nameOnPage));
    }

}

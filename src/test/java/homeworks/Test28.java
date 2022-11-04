package homeworks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class Test28 {

    @BeforeMethod
    public void before(){
        Configuration.browserSize = "2048x1024";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void rozetkaTest() {
    $(By.xpath("//*[@class='menu-categories menu-categories_type_main']/li[1]"))
            .click();
    $(By.xpath("//*[contains(@href, '80004')]"))
            .click();
        SelenideElement firstProduct = $(By.xpath("//span[@class='goods-tile__title']"));
        String firstProductName = firstProduct.text();
        $(By.xpath("//button[contains(@class, 'buy-button')]"))
                .click();

        SelenideElement counterCart = $(By.xpath("//span[contains(@class, 'counter')]"));
        String counterCartText = counterCart.text();
        Assert.assertEquals(counterCartText,"1","Product doesn't added");

        $(By.xpath("//*[contains(@class,'header__button--active')]"))
                .click();

        SelenideElement productInCart = $(By.xpath("//*[@data-testid='title']"));
        String productInCartName = productInCart.text();
        Assert.assertEquals(firstProductName,productInCartName,"Products doesn't match");
    }

}

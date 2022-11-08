package homeworks.homework29;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ProductsPageElement {

    SelenideElement firstProduct = $(byXpath("//span[@class='goods-tile__title']"));
    SelenideElement btnToCart = $(byXpath("//button[contains(@class, 'buy-button')]"));
    SelenideElement counterCart = $(byXpath("//span[contains(@class, 'counter')]"));
    SelenideElement btnCartHeader = $(byXpath("//*[contains(@class,'header__button--active')]"));

}

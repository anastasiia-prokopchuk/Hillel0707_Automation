package homeworks.homework29;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CartPageElement {
    SelenideElement productInCart = $(byXpath("//*[@data-testid='title']"));
}

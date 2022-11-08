package homeworks.homework29;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CategoryPageElement {
    SelenideElement laptopCategory = $(byXpath("//*[contains(@href, '80004')]"));
}

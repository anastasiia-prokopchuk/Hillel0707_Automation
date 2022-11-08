package homeworks.homework29;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPageElement {

    SelenideElement laptopsAndComputerCategory = $(byXpath("//*[@class='menu-categories menu-categories_type_main']/li[1]"));
}

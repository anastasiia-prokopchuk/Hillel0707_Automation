package homeworks.homework29;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class MainPageElement {

    ElementsCollection mainPageCategoryList = $$(byXpath("//*[@class='menu-categories menu-categories_type_main']/li"));
}

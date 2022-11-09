package homeworks.homework29;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$$;

public class CategoryPageElement {
    ElementsCollection categoryList = $$(byXpath("//*[@class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted']"));

}

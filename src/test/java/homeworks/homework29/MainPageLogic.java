package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic extends MainPageElement{
    public CategoryPageLogic clickOnMainCategory(int indexMainCategory){
        SelenideElement category = mainPageCategoryList.get(indexMainCategory);
        category.shouldBe(Condition.visible);
        category.click();
        return page(CategoryPageLogic.class);
    }
}

package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class CategoryPageLogic extends CategoryPageElement{
    public ProductsPageLogic clickOnCategory(SelenideElement category){
        category.shouldBe(Condition.visible).click();
        return page(ProductsPageLogic.class);
    }

}

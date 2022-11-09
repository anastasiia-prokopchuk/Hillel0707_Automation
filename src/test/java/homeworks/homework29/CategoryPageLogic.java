package homeworks.homework29;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.page;

public class CategoryPageLogic extends CategoryPageElement{
    public ProductsPageLogic clickOnCategory(int indexCategory){
        categoryList.get(indexCategory).shouldBe(Condition.visible).click();
        return page(ProductsPageLogic.class);
    }

}

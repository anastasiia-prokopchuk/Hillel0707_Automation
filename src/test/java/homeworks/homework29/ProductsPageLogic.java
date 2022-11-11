package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class ProductsPageLogic extends ProductsPageElement {
    public void addProductToCart(int index){
        SelenideElement btnToCart = btnsToCart.get(index);
        btnToCart.shouldBe(Condition.appear);
        btnToCart.click();
    }

    public String getProductName(int indexNumber){
      return productsList.get(indexNumber).getText().trim();
    }

    public ProductsPageLogic checkCountOnCart(String count){
        counterCart.shouldBe(Condition.text(count));
        return this;
    }

    public CartPageLogic clickBtnCartHeader(){
        btnCartHeader.click();
        return page(CartPageLogic.class);
    }
}

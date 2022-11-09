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

    public String productName(int indexNumber){
      return productsList.get(indexNumber).getText().trim();
    }

    public void checkCountOnCart(String count){
        counterCart.shouldBe(Condition.text(count));
    }

    public CartPageLogic clickBtnCartHeader(){
        btnCartHeader.click();
        return page(CartPageLogic.class);
    }
}

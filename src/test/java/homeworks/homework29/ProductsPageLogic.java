package homeworks.homework29;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.page;

public class ProductsPageLogic extends ProductsPageElement {
    public void addProductToCart(){
        btnToCart.click();
    }

    public String productName(SelenideElement firstProduct){
        return firstProduct.getText().trim();
    }

    public ProductsPageLogic checkCountOnCart(String number){
        counterCart.shouldBe(Condition.text(number));
        return this;
    }

    public CartPageLogic clickBtnCartHeader(){
        btnCartHeader.click();
        return page(CartPageLogic.class);
    }
}

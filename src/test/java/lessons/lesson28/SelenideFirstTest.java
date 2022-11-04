package lessons.lesson28;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideFirstTest {

    @BeforeMethod
    public void before(){
        Configuration.browserSize = "2048x1024";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest(){
        $(".search-form__input[_ngcontent-rz-client-c98]")
                .setValue("Mac");
        $(By.xpath("//button[contains(@class, 'button_color_green')]"))
                .shouldBe(visible)
                .shouldHave(text("Найти"))
                .shouldNotHave(text("Alex"))
                .click();
        sleep(5000);
    }


}

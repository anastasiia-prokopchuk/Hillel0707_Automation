package lessons.lesson28;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class SelenideExmlMethods {

    @BeforeMethod
    public void before(){
        Configuration.browserSize = "2048x1024";
        open("https://rozetka.com.ua/ua/");
    }

    @Test
    public void firstTest(){
        SelenideElement findBtn = $(byXpath("//button[contains(@class, 'button_color_green')]"));
        String textFromFindBtn = findBtn.text();
        System.out.println(textFromFindBtn);

        String fromActionAttrFronFindBtn = findBtn.attr("formAction");
        System.out.println(fromActionAttrFronFindBtn);

        String backGroundFromFindBtn = findBtn.getCssValue("background-color");
        System.out.println(backGroundFromFindBtn);
    }

}

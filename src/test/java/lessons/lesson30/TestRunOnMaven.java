package lessons.lesson30;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestRunOnMaven {
    @Test
    public void testOnMaven() {
        open("https://www.google.com/ua/");
        System.out.println("Test run on Maven");

    }
}

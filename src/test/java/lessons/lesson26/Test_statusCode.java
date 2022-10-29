package lessons.lesson26;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_statusCode {


    @Test
    public void uploadTest() throws InterruptedException, IOException {
        //сли добавить дата провайдер - можно проверить пачку урлов
        HttpURLConnection c = (HttpURLConnection)
                new URL("https://the-internet.herokuapp.com/upload").openConnection();
        c.connect();
        int statusCode = c.getResponseCode();
        System.out.println(statusCode);
        Assert.assertEquals(statusCode,200);


    }

}

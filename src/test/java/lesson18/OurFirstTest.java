package lesson18;

import org.testng.annotations.*;

public class OurFirstTest {

//    анотації
//    @BeforeClass
//    @BeforeTest
//    @AfterTest
//    @Parameters


//    атрибути
//    alwaysRun = true - завжди запуститься
//    dependsOnMethods="firstTest" - залежить від..., не запуститься якщо попередній фейл
//    groups = "payment"
//    @Test(dependsOnGroups="payment")
//    @Test(dependsOnGroups="payment", alwaysRun = true) - запуститься
//    priority = 1, priority = 0
//    enabled = false - тест не зпускається
//    timeOut = 1 - в ms
//    invocationCount = 3 - цикл, invocationTimeOut = 1 - запуск в рамках 34 ms

    @Test(expectedExceptions = {ArithmeticException.class})
    public void firstTest(){
        System.out.println("opened google.com.ua");
        System.out.println(7/0);
    }

    @Test(enabled = false)
    public void secondTest(){
        System.out.println("opened apple.com");
    }



}

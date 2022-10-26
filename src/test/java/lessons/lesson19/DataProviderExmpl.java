package lessons.lesson19;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExmpl {
    @DataProvider(name = "routes")
    public Object[][] dataProviderMethod(){
        return new Object[][]{{"route_1, www.ithillel.ua/contacts"},
                {"route_2, www.ithillel.ua"},
                {"route_3, www.ithillel.ua"},
                {"route_4, www.ithillel.ua"},
                {"route_5, www.ithillel.ua"}};
    }

    @Test(dataProvider = "routes")
    public void testCheckingLogo(String data){
        System.out.println("Test started with data: " + data);
        System.out.println("checking logo");
    }

}

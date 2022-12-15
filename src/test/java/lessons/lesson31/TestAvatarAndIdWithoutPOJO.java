package lessons.lesson31;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class TestAvatarAndIdWithoutPOJO {
    private final static String URL = "https://reqres.in/";

    @Test
    public void TestAvatarAndLogin(){
     Response response = given()
                .when()
                .get(URL+"api/users?page=2")
                .then().log().all()
               .body("page", equalTo(2))
               .body("data.id", notNullValue())
               .body("data.email", notNullValue())
               .body("data.first_name", notNullValue())
               .body("data.last_name", notNullValue())
               .body("data.avatar", notNullValue())
               .extract().response();

        JsonPath jsonPath = response.jsonPath();
        List<Integer> ids = jsonPath.get("data.id");
        List<String> emails = jsonPath.get("data.email");
        List<String> avatars = jsonPath.get("data.avatar");

        for(int i=0; i<avatars.size();i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i).toString()));
        }

        Assert.assertTrue(emails.stream().allMatch(x->x.endsWith("reqres.in")));

    }



}

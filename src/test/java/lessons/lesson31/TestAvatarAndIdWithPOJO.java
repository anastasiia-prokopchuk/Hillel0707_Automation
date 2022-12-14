package lessons.lesson31;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class TestAvatarAndIdWithPOJO {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndLogin(){

        Specification.installSpec(Specification.requestSpecification(URL)
        , Specification.responseSpecification(200));

      List<UserData> users = given()
              .when()
             // .contentType(ContentType.JSON)
              .get(URL+"api/users?page=2")
              .then().log().all()
              .extract().body().jsonPath().getList("data",UserData.class);

//      users.stream().forEach(x-> Assert.assertTrue(x.getAvatar().contains(x.getId().toString())));
//
//      Assert.assertTrue(users.stream().allMatch(x->x.getEmail().endsWith("reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());

        List<String> ids = users.stream().map(x->x.getId().toString()).collect(Collectors.toList());
        for(int i=0;i<avatars.size();i++){
            Assert.assertTrue(avatars.get(i).contains(ids.get(i)));
        }

    }
}

package lessons.lesson31;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class TestSuccsessRegWithPOJO {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndLogin() {

        Integer expectedId = 4;
        String expectedToken = "QpwL5tke4Pnpja7X4";
        Specification.installSpec(Specification.requestSpecification(URL)
                , Specification.responseSpecification(200));

        Register register = new Register("eve.holt@reqres.in","pistol");

        SuccessUserReg successUserReg = given()
                .body(register)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessUserReg.class);

        Assert.assertNotNull(successUserReg.getId());
        Assert.assertNotNull(successUserReg.getToken());

        Assert.assertEquals(successUserReg.getId(),expectedId);
        Assert.assertEquals(successUserReg.getToken(),expectedToken);

    }
}

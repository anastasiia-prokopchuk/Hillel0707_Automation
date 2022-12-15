package lessons.lesson31;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UnsuccessRegWithPOJO {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatarAndLogin() {

        String expectedError = "Missing password";

        Specification.installSpec(Specification.requestSpecification(URL)
                , Specification.responseSpecification(400));

        Register register = new Register("sydney@fife");

        UnsuccessedUserReg unsuccessedUserReg = given()
                .body(register)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(UnsuccessedUserReg.class);

        Assert.assertNotNull(unsuccessedUserReg.getError());
        Assert.assertEquals(unsuccessedUserReg.getError(), expectedError);

    }
}

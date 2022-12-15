package lessons.lesson31;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestDeletingUser {
    private final static String URL = "https://reqres.in/";

    @Test
    public void testDeleting(){
        Specification.installSpec(Specification.requestSpecification(URL)
                , Specification.responseSpecification(204));

            given()
            .when()
            .delete("api/users/2")
            .then().log().all();

    }
}

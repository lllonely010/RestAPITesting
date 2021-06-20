package posts;

import base.BaseTest;
import static io.restassured.RestAssured.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

@RunWith(JUnitPlatform.class)
public class DeleteTest extends BaseTest{

    @Test public void
    testDeleteResponse() {
        given().pathParam("userId","1").when().delete(POSTSURL+"/{userId}").then().statusCode(200);
    }

}

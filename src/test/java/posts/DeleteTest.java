package posts;

import base.BaseTest;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

@RunWith(JUnitPlatform.class)
public class DeleteTest extends BaseTest{

    @BeforeEach
    public void
    start() {
        LOGGER.info("Test DELETE with /posts/{userId} endpoint.");
    }

    @Test public void
    testDeleteResponse() {
        given().pathParam("userId","1").when().delete(POSTSURL+"/{userId}").then().statusCode(200);
    }

}

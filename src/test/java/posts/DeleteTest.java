package posts;

import base.BaseTest;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Tag;

@Tag("posts")
@RunWith(JUnitPlatform.class)
public class DeleteTest extends BaseTest{

    @BeforeEach
    public void
    start() {
        LOGGER.info("Test DELETE with /posts/{userId} endpoint.");
    }

    @Test public void
    testDeleteResponseWithValidUserId() {
        given().pathParam("userId","1").when().delete(POSTSURL+"/{userId}").then().statusCode(200);
    }

    @Disabled
    @Test public void
    testDeleteResponseWithInvalidUserId() {  //// the case succeed, but should be an error code
        given().pathParam("userId","2000").when().delete(POSTSURL+"/{userId}").then().statusCode(200);
    }

}

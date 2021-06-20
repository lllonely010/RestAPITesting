package posts;

import base.BaseTest;
import static io.restassured.RestAssured.*;

import objects.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

@Tag("posts")
@RunWith(JUnitPlatform.class)
public class PutTest extends BaseTest{

    @BeforeEach
    public void
    start() {
        LOGGER.info("Test PUT with /posts endpoint.");
    }

    @Test public void
    testPutResponseSucceed() {
        Post postbody = new Post(1,1,"foo","bar");
        given(requestSpec).pathParam("userId","1").when().body(postbody).put(POSTSURL+"/{userId}").then().statusCode(200).body("id", equalTo(1));
    }
    @Test public void
    testPutResponseSucceedWithoutHeader() {
        Post postbody = new Post(1,1,"foo","bar");
        given().pathParam("userId","1").when().body(postbody).put(POSTSURL+"/{userId}").then().statusCode(200).body("id", equalTo(1));
    }
    @Test public void
    testPutResponseFailedWithInvalidBody() {
        Post postbody = new Post(2222,2222,"foo","bar");
        given(requestSpec).pathParam("userId","2222").when().body(postbody).put(POSTSURL+"/{userId}").then().statusCode(500);
    }

    @Test public void
    testPutResponseFailedWithoutBody() {
        given(requestSpec).pathParam("userId","2222").when().put(POSTSURL+"/{userId}").then().statusCode(500);
    }
}

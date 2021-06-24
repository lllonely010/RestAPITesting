package posts;

import base.BaseTest;
import static io.restassured.RestAssured.*;

import objects.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

@Tag("posts")
@RunWith(JUnitPlatform.class)
class PatchTest extends BaseTest{

    @BeforeEach
    public void
    start() {
        LOGGER.info("Test Patch with /posts endpoint.");
    }

    @Test void
    testPatchResponseSucceedWithValidUserID() {
        Post postbody = new Post(1,1,"foo","bar");
        given(requestSpec).pathParam("userId","1").when().body(postbody).patch(POSTSURL+"/{userId}")
                .then().statusCode(200)
                .body("userId", equalTo(1))
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"));
    }

    @Test void
    testPatchResponseSucceedWithoutFullBody() {
        Post postbody = new Post(1,"foo");
        given(requestSpec).pathParam("userId","1").when().body(postbody).patch(POSTSURL+"/{userId}")
                .then().statusCode(200)
                .body("userId", equalTo(1))
                .body("title", equalTo("foo"));
    }

    @Disabled("the case failed, title is not updated")
    @Test void
    testPatchResponseSucceedWithoutHeader() {
        Post postbody = new Post(1,1,"foo","bar");
        given().pathParam("userId","1").when().body(postbody).patch(POSTSURL+"/{userId}")
                .then().statusCode(200)
                .body("userId", equalTo(1))
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"));
    }

    @Disabled("the case succeed, but should be an error code")
    @Test void
    testPatchResponseSucceedWithInvalidUserID() {
        Post postbody = new Post(2222,2222,"foo","bar");
        given(requestSpec).pathParam("userId","2222").when().body(postbody).patch(POSTSURL+"/{userId}")
                .then().statusCode(200);
    }

    @Disabled("the case succeed, but should be an error code")
    @Test void
    testPatchResponseSucceedWithoutBody() {
        given(requestSpec).pathParam("userId","2222").when().patch(POSTSURL+"/{userId}")
                .then().statusCode(200);
    }
}
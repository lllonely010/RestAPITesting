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
class PostTest extends BaseTest{

    @BeforeEach void
    start() {
        LOGGER.info("Test POST with /posts endpoint.");
    }

    @Test void
    testPostResponseSucceedWithValidBody() {
        Post postbody = new Post(1,"foo","bar");
        given(requestSpec).when().body(postbody).post(POSTSURL)
                .then().statusCode(201)
                .body("id", equalTo(101))
                .body("userId", equalTo(1))
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"));
    }

    @Disabled("the case succeed, but should be an error code")
    @Test void
    testPostResponseSucceedWithWithoutBody() {
        given(requestSpec).when().post(POSTSURL).then().statusCode(201);
    }

}
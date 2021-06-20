package posts;

import base.BaseTest;
import static io.restassured.RestAssured.*;

import objects.Post;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

@RunWith(JUnitPlatform.class)
public class PatchTest extends BaseTest{

    @Test public void
    testPatchResponseSucceedWithValidUserID() {
        Post postbody = new Post(1,1,"foo","bar");
        given(requestSpec).pathParam("userId","1").when().body(postbody).patch(POSTSURL+"/{userId}").then().statusCode(200).body("id", equalTo(1));
    }

    @Test public void
    testPatchResponseSucceedWithoutHeader() {
        Post postbody = new Post(1,1,"foo","bar");
        given().pathParam("userId","1").when().body(postbody).patch(POSTSURL+"/{userId}").then().statusCode(200).body("id", equalTo(1));
    }

    @Test public void
    testPatchResponseSucceedWithInvalidUserID() {
        Post postbody = new Post(2222,2222,"foo","bar");
        given(requestSpec).pathParam("userId","2222").when().body(postbody).patch(POSTSURL+"/{userId}").then().statusCode(200).body("id", equalTo(2222));
    }
    @Test public void
    testPatchResponseSucceedWithoutBody() {
        given(requestSpec).pathParam("userId","2222").when().patch(POSTSURL+"/{userId}").then().statusCode(200);
    }
}
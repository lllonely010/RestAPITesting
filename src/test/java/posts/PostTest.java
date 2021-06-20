package posts;

import base.BaseTest;
import static io.restassured.RestAssured.*;

import objects.Post;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.equalTo;

@RunWith(JUnitPlatform.class)
public class PostTest extends BaseTest{

    @Test public void
    testPostResponseSucceedWithValidBody() {
        Post postbody = new Post(1,"foo","bar");
        given(requestSpec).when().body(postbody).post(POSTSURL).then().statusCode(201).body("id", equalTo(101));
    }

    @Test public void
    testPostResponseSucceedWithWithoutBody() {
        given(requestSpec).when().post(POSTSURL).then().statusCode(201);
    }

}
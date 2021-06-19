package posts;

import base.BaseTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

@RunWith(JUnitPlatform.class)
public class TestPosts extends BaseTest {

    @Test
    public void getTest() {
        given().contentType("application/json").expect().statusCode(200).when().get(POSTSURL);

    }

}
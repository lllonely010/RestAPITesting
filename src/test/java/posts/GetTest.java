package posts;

import base.BaseTest;

import java.util.List;
import java.util.Map;
import io.restassured.common.mapper.TypeRef;
import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Tag("posts")
@RunWith(JUnitPlatform.class)
public class GetTest extends BaseTest{

    @BeforeEach
    public void
    start() {
        LOGGER.info("Test GET with /posts endpoint.");
    }

    @Test public void
    testResponseStatusCode() {
        expect().statusCode(200).when().get(POSTSURL);
    }

    @Test public void
    testResponseHasSize() {
        expect().body("$",hasSize(100)).when().get(POSTSURL);
    }

    @Test public void
    testResponseValue() {
        List<Map<String, Object>> posts = get(POSTSURL).as(new TypeRef<List<Map<String, Object>>>() {});
        assertThat(posts, hasSize(100));
        assertThat(posts.get(0).get("userId"), equalTo(1));
        assertThat(posts.get(0).get("id"), equalTo(1));
        assertThat(posts.get(0).get("title"), equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
    }
}

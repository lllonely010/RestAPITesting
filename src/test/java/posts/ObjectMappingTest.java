package posts;

import base.BaseTest;

import static io.restassured.RestAssured.*;

import objects.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Tag("posts")
@RunWith(JUnitPlatform.class)
class ObjectMappingTest extends BaseTest {

    @BeforeEach void
    start() {
        LOGGER.info("Test Post object mapping with /posts endpoint.");
    }

    @Test void
    testMapResponseToObjectUsingPost() {

        final Post object;
        object = given().pathParam("userId","1").when().get(POSTSURL+"/{userId}").as(Post.class);

        assertThat(object.getId(), equalTo(1));
        assertThat(object.getUserId(), equalTo(1));
        assertThat(object.getTitle(), equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
        assertThat(object.getBody(), equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }

}
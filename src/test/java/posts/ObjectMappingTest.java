package posts;

import base.BaseTest;

import static io.restassured.RestAssured.*;

import objects.Post;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import support.PropertyManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(JUnitPlatform.class)
public class ObjectMappingTest extends BaseTest {

    @Test public void
    testMapResponseToObjectUsingPost() {
        String POSTSEDITURL = PropertyManager.getInstance().getPostEditUri(1);

        final Post object;
        object = get(POSTSEDITURL).as(Post.class);


        assertThat(object.getId(), equalTo(1));
        assertThat(object.getUserId(), equalTo(1));
        assertThat(object.getTitle(), equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"));
        assertThat(object.getBody(), equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }

}
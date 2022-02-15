package tests;

import base.BasicTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import objects.Post;
import java.util.List;
import java.util.Map;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@Feature("Check /posts endpoint")
@Tag("posts")
class PostsTest extends BasicTest {

    @Description("Check get posts status code")
    @Test void
    testPostsResponseStatusCode() { commonTestFunc.getPostsResponse().then().log().body().statusCode(200); }

    @Description("Check get posts response has size")
    @Test  void
    testPostsResponseHasSize() {
        commonTestFunc.getPostsResponse().then().body("$",hasSize(100));
    }

    @Description("Check get posts response value")
    @Test void
    testPostsResponseValue() {
        List<Map<String, Object>> posts = commonTestFunc.getPostsResponse().as(new TypeRef<>() {
        });
        assertAll("post value",
                () -> assertThat(posts, hasSize(100)),
                () -> assertThat(posts.get(0).get("userId"), equalTo(1)),
                () -> assertThat(posts.get(0).get("id"), equalTo(1)),
                () -> assertThat(posts.get(0).get("title"), equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));
    }

    @Description("Check delete posts with valid userId")
    @Test void
    testDeletePostsResponseWithValidUserId() {
        commonTestFunc.deletePostWithUserId("1").then().statusCode(200);
    }

    @Description("Check delete posts with Invalid userId")
    @Test void
    testDeletePostsResponseWithInValidUserId() {
        commonTestFunc.deletePostWithUserId("ssss").then().statusCode(200);
    }

    @Description("Check post posts with valid userId")
    @Test void
    testPatchPostsResponseSucceedWithValidUserID() {
        Post post = new Post(1,1,"foo","bar");
        commonTestFunc.updatePostWithUserId("1", post)
                .then().statusCode(200)
                .body("userId", equalTo(1))
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"));
    }

    @Description("Check patch posts without full body")
    @Test void
    testPatchPostsResponseSucceedWithoutFullBody() {
        Post post = new Post(1,"foo");
        commonTestFunc.updatePostWithUserId("1", post)
                .then().statusCode(200)
                .body("userId", equalTo(1))
                .body("title", equalTo("foo"));
    }

    @Description("Check patch posts without header")
    @Test void
    testPatchPostsResponseSucceedWithoutHeader() {
        Post post = new Post(1,1,"foo","bar");
        commonTestFunc.updatePostWithUserId("1", post)
                .then().statusCode(200)
                .body("userId", equalTo(1))
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"));
    }

    @Description("Check patch posts with invalid userId")
    @Test void
    testPatchResponseSucceedWithInvalidUserID() {
        Post post = new Post(2222,2222,"foo","bar");
        commonTestFunc.updatePostWithUserId("2222", post).then().statusCode(200);
    }

    @Description("Check put posts ")
    @Test void
    testPutResponseSucceed() {
        Post post = new Post(1,1,"foo","bar");
        commonTestFunc.updatePostWithUserId("1", post).then().statusCode(200).body("id", equalTo(1));
    }

    @Description("Check put posts without invalid body")
    @Test void
    testPutResponseFailedWithInvalidBody() {
        Post post = new Post(2222,2222,"foo","bar");
        commonTestFunc.updatePostWithUserId("2222", post).then().statusCode(200);
    }

    @Description("Check get posts using object mapping")
    @Test void
    testMapResponseToObjectUsingPost() {
        Post object = commonTestFunc.getPostsByUserID("1").as(Post.class);
        assertAll("post object",
                () -> assertEquals(1, object.getId()),
                () -> assertEquals(1, object.getUserId()),
                () -> assertEquals("sunt aut facere repellat provident occaecati excepturi optio reprehenderit", object.getTitle()),
                () -> assertEquals("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto", object.getBody()));
    }

}

package func;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.Post;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import support.PropertyManager;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CommonTestFunc {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonTestFunc.class);

    protected RequestSpecification getBaseRequest() {
        return given().log().uri().header("Content-Type", "application/json")
                .baseUri(PropertyManager.getInstance().getBaseUri());
    }

    public Response getPostsResponse(){
        return getBaseRequest().when().get("/posts");
    }

    public Response getPostsByUserID(String userId){
        return getBaseRequest().pathParam("userId",userId).when().get("/posts/{userId}");
    }

    public Response updatePostWithUserId(String userId, Post post){
        return getBaseRequest().body(post).pathParam("userId",userId).when().patch("/posts/{userId}");

    }

    public Response putPostWithUserId(String userId, Post post){
        return getBaseRequest().body(post).pathParam("userId",userId).when().put("/posts/{userId}");

    }

    public Response deletePostWithUserId(String userId){
        return getBaseRequest().pathParam("userId",userId).when().delete("/posts/{userId}");

    }

    public Response getCommentByPostID(int postId){
        return getBaseRequest().param("postId",postId).when().get("/comments/{postId}");
    }

    public Response getUsers(){
        return getBaseRequest().when().get("/users");
    }

    public String getUserNameById(int userId){

        List<Map<String, Object>> users = this.getUsers().as(new TypeRef<List<Map<String, Object>>>() {});
        return users.get(userId).get("name").toString();
    }
}

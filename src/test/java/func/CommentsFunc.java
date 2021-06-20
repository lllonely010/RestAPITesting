package func;

import base.BaseFunc;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CommentsFunc extends BaseFunc {

    public static Response getCommentByPostID(int postId){
        LOGGER.info("Get comment by postId = " + postId);
        Response CommentRes = given().param("postId",postId).expect().statusCode(200).when().get(COMMENTURL);
        return CommentRes;
    }
}

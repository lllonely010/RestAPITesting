package funs;

import base.BaseFun;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostsFun extends BaseFun {

    public static Response getPostsByUserID(int userId, String url){
        LOGGER.info("Get post by userId = " + userId);
        Response postRes = given().param("userId",userId).expect().statusCode(200).when().get(url);
        return postRes;
    }
}

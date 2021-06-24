package posts;

import base.BaseTest;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

@Tag("posts")
@RunWith(JUnitPlatform.class)
class ParamTest extends BaseTest{

    @BeforeEach void
    start() {
        LOGGER.info("Test param userId with /posts endpoint.");
    }

    @Test void
    testGetWithParamSucceed() {
        given().param("userId",1).expect().statusCode(200).when().get(POSTSURL);
    }
}
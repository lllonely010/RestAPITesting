package posts;

import base.BaseTest;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(JUnitPlatform.class)
public class ParamTest extends BaseTest{

    @BeforeEach
    public void
    start() {
        LOGGER.info("Test param userId with /posts endpoint.");
    }

    @Test public void
    testGetWithParamSucceed() {
        given().param("userId",1).expect().statusCode(200).when().get(POSTSURL);
    }
}
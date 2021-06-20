package posts;

import base.BaseTest;

import static io.restassured.RestAssured.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(JUnitPlatform.class)
public class ParamTest extends BaseTest{

    @Test public void
    testGetWithParamSucceed() {
        given().param("userId",1).expect().statusCode(200).when().get(POSTSURL);
    }

}
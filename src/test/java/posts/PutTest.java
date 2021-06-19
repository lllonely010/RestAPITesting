package posts;

import base.BaseTest;
import static io.restassured.RestAssured.*;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.Test;
import support.PropertyManager;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@RunWith(JUnitPlatform.class)
public class PutTest extends BaseTest{

    @Test public void
    testPutResponse() {
        String POSTSEDITURL = PropertyManager.getInstance().getPostEditUri(3);
        when().put(POSTSEDITURL).then().statusCode(200).body("id", equalTo(3));
    }

}

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
public class DeleteTest extends BaseTest{

    @Test public void
    testDeleteResponse() {
        String POSTSEDITURL = PropertyManager.getInstance().getPostEditUri(5);
        when().delete(POSTSEDITURL).then().statusCode(200);
    }

}

package base;

import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import support.PropertyManager;


@RunWith(JUnitPlatform.class)
public abstract class BaseTest {

    public static Logger LOGGER = LogManager.getLogger(BaseTest.class);

    protected static final String POSTSURL = PropertyManager.getInstance().getPostsUri();
    protected static final String USERURL = PropertyManager.getInstance().getUsersUri();
    protected static final String COMMENTURL = PropertyManager.getInstance().getCommentsUri();

    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .addHeader("Content-Type", "application/json")
            .build();

    @BeforeAll
    public static void setupAll() { LOGGER.info("Start to set up for all tests"); }

    @AfterAll
    public static void teardownAll() { LOGGER.info("All tests finished"); }

}

package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import support.PropertyManager;


@RunWith(JUnitPlatform.class)
public abstract class BaseTest {

    public static Logger LOGGER = LogManager.getLogger(BaseTest.class);
    protected static final String BASEURL = PropertyManager.getInstance().getBaseUri();
    protected static final String POSTSURL = PropertyManager.getInstance().getPostsUri();


    @BeforeAll
    public static void setupAll() {
        LOGGER.info("Start to set up for all tests");
    }


    @AfterAll
    public static void teardownAll() {

        LOGGER.info("All tests finished");
    }

}

package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;


@RunWith(JUnitPlatform.class)
public abstract class BaseTest extends Base{

    @BeforeAll
    public static void setupAll() { LOGGER.info("Start to set up for all tests"); }

    @AfterAll
    public static void teardownAll() { LOGGER.info("All tests finished"); }

}

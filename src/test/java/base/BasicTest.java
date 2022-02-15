package base;

import func.CommonTestFunc;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasicTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicTest.class);

    public CommonTestFunc commonTestFunc = new CommonTestFunc();

    @BeforeAll
    public static void setupAll() {
        LOGGER.info("Start to set up for all tests");
    }

    @AfterAll
    public static void teardownAll() { LOGGER.info("All tests finished"); }


}

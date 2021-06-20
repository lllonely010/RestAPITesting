package support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;
import org.slf4j.Logger;

public class PropertyManager {

    private static PropertyManager pm;
    private static final String propertyFilePath = System.getProperty("user.dir") + "/resources/application.properties";
    private String baseUri;
    private String postsUri;
    private String usersUri;
    private String commentsUri;


    static Logger log = getLogger(lookup().lookupClass());

    public static PropertyManager getInstance() {
        if (pm == null) {
            pm = new PropertyManager();
            pm.loadData();
        }
        return pm;
    }

    private void loadData() {
        Properties prop = new Properties();
        log.info("Read configuration.properties file");

        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            log.error("Configuration properties file cannot be found");
        }

        baseUri = prop.getProperty("baseUri");
        postsUri= prop.getProperty("posts");
        usersUri = prop.getProperty("users");
        commentsUri = prop.getProperty("comments");
    }

    public String getBaseUri() {
        return baseUri;
    }
    public String getPostsUri() {
        return baseUri + postsUri;
    }
    public String getUsersUri() {
        return baseUri + usersUri;
    }
    public String getCommentsUri() {
        return baseUri + commentsUri;
    }


}
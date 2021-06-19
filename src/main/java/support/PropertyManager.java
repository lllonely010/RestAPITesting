package support;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertyManager {

    private static PropertyManager pm;
    private static final String propertyFilePath = System.getProperty("user.dir") + "/resources/application.properties";
    public static String logFilePath = System.getProperty("user.dir") + "/resources/log4j2.xml";
    private String baseUri;
    private String postsUri;
    private String postEditUri;


    static {
        System.setProperty("log4j.configurationFile", logFilePath);
    }

    private final Logger log = LogManager.getLogger(PropertyManager.class);

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

    }

    public String getBaseUri() {
        return baseUri;
    }
    public String getPostsUri() {
        return baseUri + postsUri;
    }
    public String getPostEditUri(int userId) {
        return baseUri + postsUri + "/" + userId;
    }


}
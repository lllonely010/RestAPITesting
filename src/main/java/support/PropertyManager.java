package support;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyManager {

    private static PropertyManager pm;
    private static final String FILEPATH = System.getProperty("user.dir") + "/resources/application.properties";
    private String baseUri;


    static Logger log = LoggerFactory.getLogger(PropertyManager.class);

    public static PropertyManager getInstance() {
        if (pm == null) {
            pm = new PropertyManager();
            pm.loadData();
        }
        return pm;
    }

    private void loadData(){
        Properties prop = new Properties();
        log.info("Read configuration.properties file");
        try (FileInputStream stream = new FileInputStream(FILEPATH)) {
            prop.load(stream);
        } catch (IOException e) {
            log.error("Configuration properties file cannot be found");
        }
        baseUri = prop.getProperty("baseUri");

    }

    public String getBaseUri() {
        return baseUri;
    }

}
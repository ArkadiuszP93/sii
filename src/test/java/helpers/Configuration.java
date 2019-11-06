package helpers;

import java.io.IOException;
import java.util.Properties;

/**
 * Basic Configuration
 */
public class Configuration {
    private static final String SITE_ADDRESS_PROPERTY = "test.site.url";
    private static final String DRIVER_LOCATION_PROPERTY = "driver.location";
    private static final String FIREFOX_DRIVER_LOCATION_PROPERTY = "firefox.driver.location";
    private static final String IE_DRIVER_LOCATION_PROPERTY = "ie.driver.location";
    private static Configuration configuration;
    private Properties properties;
    private String siteURL;
    private String driverLocation;
    private String firefoxDriverLocation;
    private String ieDriverLocation;

    private Configuration() {
        try {
            properties = new Properties();
            properties.load(Configuration.class.getClassLoader().getResourceAsStream("configuration.properties"));
        } catch (
                IOException exception) {
            throw new ExceptionInInitializerError(exception);
        }
        siteURL = extractProperty(SITE_ADDRESS_PROPERTY);
        driverLocation = extractProperty(DRIVER_LOCATION_PROPERTY);
        firefoxDriverLocation = extractProperty(FIREFOX_DRIVER_LOCATION_PROPERTY);
        ieDriverLocation = extractProperty(IE_DRIVER_LOCATION_PROPERTY);
    }

    private String extractProperty(String propertyName) {
        String property = System.getProperty(propertyName);
        if (property == null) {
            property = properties.getProperty(propertyName);
        }
        return property;
    }

    public static Configuration getConfiguration() {
        if (configuration == null) {
            configuration = new Configuration();
        }
        return configuration;
    }

    public String getSiteURL() {
        return siteURL;
    }

    public String getDriverLocation() {
        return driverLocation;
    }

    public String getFirefoxDriverLocation() {
        return firefoxDriverLocation;
    }

    public String getIEDriverLocation() {
        return ieDriverLocation;
    }
}

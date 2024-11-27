package utiltiy;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    // Load the properties file
    static {
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Unable to load configuration file.");
        }
    }

    // Method to get the base URL from the properties file
    public static String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    // Method to get the login endpoint
    public static String getLoginEndpoint() {
        return properties.getProperty("login.endpoint");
    }

    // Method to get the authentication token
    public static String getAuthToken() {
        return properties.getProperty("auth.token");
    }



    // Method to get the vendor type
    public static String getVendorType() {
        return properties.getProperty("vendorType");
    }}



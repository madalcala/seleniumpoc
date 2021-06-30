package todoly.core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Util used to read the configuration files.
 *
 * @author Maday Alcala
 * @since 06/28/2021
 */
public final class PropertyReader {
    private static Properties properties = new Properties();

    /**
     * Private constructor for utility class.
     */
    private PropertyReader() {
    }

    /**
     * Loads a configuration file into a Properties object.
     *
     * @param filename String containing the name of the config file intended to be read.
     */
    public static void loadFile(final String filename) {
        try (InputStream input = new FileInputStream(filename)) {
            properties.load(input);
        } catch (IOException ioex) {
            throw new RuntimeException(ioex);
        }
    }

    /**
     * Retrieves the value of a given key.
     *
     * @param field a String containing the name of the key.
     * @return a String containing the value of the passed key.
     */
    public static String retrieveField(final String field) {
        return properties.getProperty(field);
    }
}

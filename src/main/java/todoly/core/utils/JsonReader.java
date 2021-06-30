package todoly.core.utils;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Util used to read the configurations from the json file.
 *
 * @author Maday Alcala
 * @since 06/28/2021.
 */
public class JsonReader {
    private Logger log = Logger.getLogger(getClass());
    private JSONObject jsonObjectMain;

    /**
     * Constructor of JsonReader.
     *
     * @param filePath - The Current path of the Json File.
     */
    public JsonReader(final String filePath) {
        parseJSON(filePath);
    }

    /**
     * Parses the json file into a JSONObject.
     *
     * @param filePath - The Current path of the Json File.
     */
    private void parseJSON(final String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            JSONParser jsonParser = new JSONParser();
            jsonObjectMain = (JSONObject) jsonParser.parse(reader);
        } catch (FileNotFoundException ex) {
            log.error("FileNotFoundException when reading the configuration file ", ex);
        } catch (ParseException ex) {
            log.error("ParseException when reading the configuration file ", ex);
        } catch (IOException ex) {
            log.error("IOException when reading the configuration file ", ex);
        } catch (NullPointerException ex) {
            log.error("NullPointerException when reading the configuration file ", ex);
        }
    }

    /**
     * Gets the jsonObject value given the key from the main json object.
     *
     * @param key - The current key.
     * @return The value from jsonObject.
     */
    public JSONObject getJSONObject(final String key) {
        return (JSONObject) jsonObjectMain.get(key);
    }

    /**
     * Gets the string value given the key from an specific jsonObject.
     *
     * @param jsonObject - The Object.
     * @param key - The key value.
     * @return A string value.
     */
    public String getKeyValueFromJSONObject(final JSONObject jsonObject, final String key) {
        return (String) jsonObject.get(key);
    }

    /**
     * Gets a jsonObject from the main json and then gets a value given the key.
     *
     * @param objectName - The name of the Object.
     * @param key - To return the data.
     * @return The data.
     */
    public String getKeyValue(final String objectName, final String key) {
        JSONObject jsonObject = getJSONObject(objectName);
        return getKeyValueFromJSONObject(jsonObject, key);
    }
}

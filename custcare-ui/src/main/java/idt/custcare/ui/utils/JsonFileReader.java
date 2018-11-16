package idt.custcare.ui.utils;

import idt.custcare.ui.config.ReservedWords;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Reads data from .json file.
 */
public final class JsonFileReader {
    private static final Logger LOGGER = LogManager.getLogger(JsonFileReader.class.getSimpleName());
    private static final String ENCODING = "UTF-8";

    /**
     * Initializes an instance of {@link JsonFileReader}.
     */
    private JsonFileReader() {
    }

    /**
     * Loads content from a json file and returns it as JSONObject.
     *
     * @param jsonFilePath the path of json file.
     * @return json object.
     */
    public static JSONObject loadJsonObjectFromFile(final String jsonFilePath) {
        JSONObject jsonObject = new JSONObject();
        String jsonPath = jsonFilePath;
        if (!new File(jsonFilePath).exists()) {
            jsonPath = jsonFilePath.replace(ReservedWords.DOUBLE_DOT_AND_SLASH.val(),
                    ReservedWords.STRING_EMPTY.val());
        }
        try (InputStreamReader inputFile = new InputStreamReader(new FileInputStream(jsonPath), ENCODING)) {
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(inputFile);
        } catch (IOException e) {
            LOGGER.warn("Problem while reading the file", e);
        } catch (ParseException e) {
            LOGGER.warn("Problem while parsing Json object", e);
        }
        return jsonObject;
    }

    /**
     * Gets specified values from a json file.
     *
     * @param jsonContent    the json object that contains another json object inside.
     * @param jsonObjectName the json object name.
     * @return json object.
     */
    public static JSONObject getJsonObjectInsideAnother(final JSONObject jsonContent, final String jsonObjectName) {
        return (JSONObject) jsonContent.get(jsonObjectName);
    }

    /**
     * Gets a Json element from a Json array in a json file.
     *
     * @param jsonContent        the json object that contains the array.
     * @param jsonObjectListName the json array field name.
     * @param elementKey         field name inside the required element.
     * @param elementValue       value to search inside the required element according field.
     * @return json object.
     */
    public static JSONObject getJsonElementFromJsonArray(final JSONObject jsonContent, final String jsonObjectListName,
                                                         final String elementKey, final String elementValue) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = (JSONArray) jsonContent.get(jsonObjectListName);
        for (Object object : jsonArray) {
            if (object instanceof JSONObject
                    && (((JSONObject) object).get(elementKey).toString()).equals(elementValue)) {
                jsonObject = (JSONObject) object;
                break;
            }
        }
        return jsonObject;
    }
}

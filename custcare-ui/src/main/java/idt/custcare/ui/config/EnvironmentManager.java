package idt.custcare.ui.config;

import idt.custcare.ui.base.login.PortalWeb;
import idt.custcare.ui.base.login.UserTypes;
import idt.custcare.ui.database.DataBases;
import idt.custcare.ui.utils.JsonFileReader;
import java.util.Objects;
import org.json.simple.JSONObject;

/**
 * Sets up Environment data for test execution.
 */
public final class EnvironmentManager {
    private static final String ENVIRONMENT_CONFIGURATIONS_FILE_PATH =
            "../custcare-ui/src/main/resources/Environment.json";
    private static EnvironmentManager instance = null;
    private UiConfig uiConfig;
    private JSONObject environmentConfig;
    private JSONObject portalConfig;
    private JSONObject userConfig;

    /**
     * Initializes an instance of {@link EnvironmentManager}.
     */
    private EnvironmentManager() {
        uiConfig = UiConfig.getInstance();
        setEnvironmentConfig();
    }

    /**
     * Initializes a singleton Environment Manager instance.
     *
     * @return singleton instance of {@link EnvironmentManager}.
     */
    public static EnvironmentManager getInstance() {
        if (Objects.isNull(instance)) {
            instance = new EnvironmentManager();
        }
        return instance;
    }

    /**
     * Configures Portal and User data according received values.
     *
     * @param portalWeb the portal web name.
     * @param userType  the user type name.
     */
    public void configureEnvironmentSettings(final PortalWeb portalWeb, final UserTypes userType) {
        setPortalConfig(portalWeb);
        setUserConfig(userType);
    }

    /**
     * Sets the global user config in a Json object.
     *
     * @param userType UserType enum value.
     */
    private void setUserConfig(final UserTypes userType) {
        userConfig = JsonFileReader.getJsonElementFromJsonArray(portalConfig, ReservedWords.USERS.val(),
                ReservedWords.TYPE.val(), userType.toString());
    }

    /**
     * Sets the global portal config in a Json object.
     *
     * @param portalName PortalWeb enum value.
     */
    private void setPortalConfig(final PortalWeb portalName) {
        portalConfig = JsonFileReader.getJsonElementFromJsonArray(environmentConfig, ReservedWords.PORTALS.val(),
                ReservedWords.NAME.val(), portalName.toString());
    }

    /**
     * Sets the global environment config in a Json object.
     */
    private void setEnvironmentConfig() {
        environmentConfig = JsonFileReader.getJsonElementFromJsonArray(
                JsonFileReader.loadJsonObjectFromFile(ENVIRONMENT_CONFIGURATIONS_FILE_PATH),
                ReservedWords.ENVIRONMENTS.val(), ReservedWords.NAME.val(), uiConfig.getEnvironment());
    }

    /**
     * Gets the base URL from environment config file.
     *
     * @return Base Url string.
     */
    public String getBaseUrl() {
        return (String) portalConfig.get(ReservedWords.BASE_URL.val());
    }

    /**
     * Gets the Login base URL from environment config file.
     *
     * @return Login Base Url string.
     */
    public String getBaseLoginUrl() {
        return (String) portalConfig.get(ReservedWords.BASE_LOGIN_URL.val());
    }

    /**
     * Gets the username from environment config file.
     *
     * @return username string.
     */
    public String getUsername() {
        return (String) userConfig.get(ReservedWords.USERNAME.val());
    }

    /**
     * Gets the password from environment config file.
     *
     * @return password string.
     */
    public String getPassword() {
        return (String) userConfig.get(ReservedWords.PASSWORD.val());
    }

    /**
     * Gets configuration from a specific database from environment config file.
     *
     * @param dataBaseName the database name to get the data.
     * @return database configuration in a JSONObject.
     */
    public JSONObject getDatabaseConfig(final DataBases dataBaseName) {
        return JsonFileReader.getJsonElementFromJsonArray(environmentConfig, ReservedWords.DBs.val(),
                ReservedWords.NAME.val(), dataBaseName.toString());
    }
}

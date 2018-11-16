package idt.custcare.ui.config;

import idt.custcare.ui.utils.PropertiesFileReader;
import java.util.Objects;

/**
 * Sets up UI configuration for test execution.
 */
public final class UiConfig {
    private static final String UI_PROP_FILE = "../custcare-ui/gradle.properties";
    private static UiConfig instance;

    private PropertiesFileReader propertiesFileReader;

    /**
     * Initializes an instance of {@link UiConfig}.
     */
    private UiConfig() {
        propertiesFileReader = new PropertiesFileReader(UI_PROP_FILE);
    }

    /**
     * Initializes the singleton UI Config instance.
     *
     * @return singleton instance.
     */
    public static synchronized UiConfig getInstance() {
        if (Objects.isNull(instance)) {
            instance = new UiConfig();
        }
        return instance;
    }

    /**
     * Gets the tests execution environment name.
     *
     * @return execution environment name.
     */
    public String getEnvironment() {
        return propertiesFileReader.getPropertyValue(ReservedWords.ENVIRONMENT_NAME.val());
    }

    /**
     * Gets the current Browser name.
     *
     * @return Browser value.
     */
    public String getBrowser() {
        return propertiesFileReader.getPropertyValue(ReservedWords.BROWSER.val());
    }

    /**
     * Gets the implicit time wait for web driver default configuration.
     *
     * @return implicit time wait value.
     */
    public int getImplicitTime() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(ReservedWords.IMPLICIT_TIME.val()));
    }

    /**
     * Gets the explicit time wait for web driver default configuration.
     *
     * @return explicit time wait value.
     */
    public int getExplicitTime() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(ReservedWords.EXPLICIT_TIME.val()));
    }

    /**
     * Gets the sleep time wait for web driver default configuration.
     *
     * @return sleep time wait value.
     */
    public int getSleepTime() {
        return Integer.parseInt(propertiesFileReader.getPropertyValue(ReservedWords.SLEEP_TIME.val()));
    }

    /**
     * Gets the page load time wait for webdriver default configuration.
     *
     * @return page load time wait value.
     */
    public long getPageLoadTime() {
        return Long.parseLong(propertiesFileReader.getPropertyValue(ReservedWords.PAGE_LOAD_TIME.val()));
    }
}

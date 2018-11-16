package idt.custcare.ui.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import idt.custcare.ui.driver.DriverManager;
import java.util.Objects;

/**
 * Hooks used for custcare tests.
 */
public class CommonHooks {
    /**
     * Initializes the Web Driver and remote connections.
     */
    @Before
    public void beforeScenario() {
        DriverManager.getInstance().initializeDriver();
    }

    /**
     * Quits the Web Driver instance.
     */
    @After
    public void afterScenario() {
        if (!Objects.isNull(DriverManager.getInstance().getWebDriver())) {
            DriverManager.getInstance().quitDriver();
        }
    }
}

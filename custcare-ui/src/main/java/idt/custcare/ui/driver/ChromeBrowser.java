package idt.custcare.ui.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Initializes an instance of a Chrome web driver.
 */
public class ChromeBrowser implements Browser {
    private static final String CHROME_DRIVER_VERSION = "2.40";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getDriver() {
        WebDriverManager.chromedriver().version(CHROME_DRIVER_VERSION).setup();
        return new ChromeDriver();
    }
}
